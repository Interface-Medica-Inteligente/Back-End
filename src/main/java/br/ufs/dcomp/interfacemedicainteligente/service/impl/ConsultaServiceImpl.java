package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Optional;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Atendimento;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Consulta;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Paciente;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Prontuario;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.AtendimentoRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.ConsultaRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.PacienteRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.ProntuarioRepository;
import br.ufs.dcomp.interfacemedicainteligente.exception.RegraNegocioException;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.AtendimentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CadastroProntuarioCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.ConsultaCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.PacienteCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.PessoaDocumentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.RelatorioLaudoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.RelatorioReceitaCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaProntuarioDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.ConsultaService;
import br.ufs.dcomp.interfacemedicainteligente.useful.GeradorRelatorioUseful;
import br.ufs.dcomp.interfacemedicainteligente.useful.ValidacaoUtil;
import br.ufs.dcomp.interfacemedicainteligente.useful.ValidatorDocumentUseful;
import net.sf.jasperreports.engine.JRException;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private Validator validator;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private ProntuarioRepository prontuarioRepository;

	/**
	 * Metodo responsavel pelo cadastro do prontuario
	 * 
	 * @param cadastroProntuarioCmd
	 * @return um {@link Long} contendo o id do prontuario cadastrado.
	 * @throws um {@link RegraNegocioException} caso o objeto passado esteja
	 *            incorreto.
	 */
	@Override
	public Long cadastrarProntuario(CadastroProntuarioCmd cadastroProntuarioCmd) {
		ValidacaoUtil.validarCmd(cadastroProntuarioCmd, validator);
		Optional<Paciente> paciente = pacienteRepository.findByCpf(cadastroProntuarioCmd.getPaciente().getCpf());

		if (paciente.isEmpty()) {
			paciente = Optional.of(cadastrarPaciente(cadastroProntuarioCmd.getPaciente()));
		}

		Long idConsulta = cadastrarConsulta(new ConsultaCmd(cadastroProntuarioCmd.getMedico(), paciente.get().getId()));

		Long idAtendimento = cadastrarAtendimento(new AtendimentoCmd(LocalDate.now(), cadastroProntuarioCmd.getPeso(),
				cadastroProntuarioCmd.getAltura(), idConsulta));

		if (prontuarioRepository.findByPaciente(paciente.get()).isEmpty()) {
			Prontuario prontuario = new Prontuario();
			prontuario.setPaciente(paciente.get());
			prontuarioRepository.save(prontuario);
		}

		return idAtendimento;
	}

	/**
	 * Metodo responsavel pela consulta do prontuario atraves do objeto
	 * {@link PessoaDocumentoCmd} contendo o documento do paciente
	 * 
	 * @param pessoaDocumentoCmd
	 * @return um {@link ConsultaProntuarioDTO} contendo os dados do prontuario.
	 * @throws um {@link RegraNegocioException} caso o objeto passado esteja
	 *            incorreto ou caso nao encontre um prontuario.
	 */
	@Override
	public ConsultaProntuarioDTO consultarProntuario(PessoaDocumentoCmd pessoaDocumentoCmd) {
		ValidacaoUtil.validarCmd(pessoaDocumentoCmd, validator);

		Optional<Atendimento> atendimento = atendimentoRepository.consultar(pessoaDocumentoCmd.getCpf());
		if (atendimento.isPresent()) {
			return new ConsultaProntuarioDTO(atendimento.get());
		}

		throw new RegraNegocioException("Não existe paciente cadastrado para este cpf");
	}

	/**
	 * Metodo responsavel por gerar o documento do laudo do pdf.
	 * 
	 * @param relatorioLaudoCmd
	 * @return o {@link byte[]} contendo um array de bytes na base64.
	 * @throws um {@link RegraNegocioException} caso o objeto passado esteja
	 *            incorreto ou caso nao tenha sido possivel gerar o documento.
	 */
	@Override
	public byte[] gerarDocumentoLaudoPDF(RelatorioLaudoCmd relatorioLaudoCmd) {
		ValidacaoUtil.validarCmd(relatorioLaudoCmd, validator);

		GeradorRelatorioUseful gerador = new GeradorRelatorioUseful();
		try {
			return Base64.getEncoder().encode(gerador.gerarRelatorioLaudo(relatorioLaudoCmd));
		} catch (JRException | FileNotFoundException e) {
			throw new RegraNegocioException("Não foi possivel gerar o pdf.");
		}
	}

	/**
	 * Metodo responsavel por gerar o documento da receita em pdf.
	 * 
	 * @param relatorioReceitaCmd
	 * @return o {@link byte[]} contendo um array de bytes na base64.
	 * @throws um {@link RegraNegocioException} caso o objeto passado esteja
	 *            incorreto ou caso nao tenha sido possivel gerar o documento.
	 */
	@Override
	public byte[] gerarDocumentoReceitaPDF(RelatorioReceitaCmd relatorioReceitaCmd) {
		ValidacaoUtil.validarCmd(relatorioReceitaCmd, validator);

		GeradorRelatorioUseful gerador = new GeradorRelatorioUseful();
		relatorioReceitaCmd.setDataEmissao(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		try {
			return Base64.getEncoder().encode(gerador.gerarRelatorioReceita(relatorioReceitaCmd));
		} catch (JRException | FileNotFoundException e) {
			throw new RegraNegocioException("Não foi possivel gerar o pdf.");
		}
	}

	private Paciente cadastrarPaciente(PacienteCmd pacienteCmd) {
		if (!ValidatorDocumentUseful.validarCpf(pacienteCmd.getCpf()))
			throw new RegraNegocioException("CPF Inválido.");

		Paciente paciente = new Paciente();

		paciente.setNome(pacienteCmd.getNome());
		paciente.setEmail(pacienteCmd.getEmail());
		paciente.setCpf(pacienteCmd.getCpf());
		paciente.setSexo(pacienteCmd.getSexo());
		paciente.setDataNascimento(pacienteCmd.getDataNascimento());
		paciente.setNomeMae(pacienteCmd.getNomeMae());
		paciente.setNomePai(pacienteCmd.getNomePai());

		return pacienteRepository.save(paciente);
	}

	private Long cadastrarConsulta(ConsultaCmd consultaCmd) {
		ValidacaoUtil.validarCmd(consultaCmd, validator);

		Medico medico = new Medico();
		Paciente paciente = new Paciente();
		Consulta consulta = new Consulta();

		medico.setId(consultaCmd.getMedico());
		paciente.setId(consultaCmd.getPaciente());

		consulta.setMedico(medico);
		consulta.setPaciente(paciente);

		return consultaRepository.save(consulta).getId();
	}

	private Long cadastrarAtendimento(AtendimentoCmd atendimentoCmd) {
		ValidacaoUtil.validarCmd(atendimentoCmd, validator);

		Consulta consulta = new Consulta();

		consulta.setId(atendimentoCmd.getConsulta());

		Atendimento atendimento = new Atendimento();

		atendimento.setAltura(atendimentoCmd.getAltura());
		atendimento.setPeso(atendimentoCmd.getPeso());
		atendimento.setDataAtendimento(atendimentoCmd.getDataAgendamento());
		atendimento.setConsulta(consulta);

		return atendimentoRepository.save(atendimento).getId();
	}
}
