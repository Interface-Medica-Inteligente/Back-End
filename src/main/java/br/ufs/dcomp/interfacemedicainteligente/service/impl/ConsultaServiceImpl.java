package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import java.time.LocalDate;
import java.util.Optional;

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
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.AtendimentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CadastroProntuarioDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaProntuarioDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PacienteDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PessoaDocumentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.ConsultaService;
import br.ufs.dcomp.interfacemedicainteligente.useful.ValidatorDocumentUseful;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private ProntuarioRepository prontuarioRepository;

	@Override
	public Long cadastrarProntuario(CadastroProntuarioDTO cadastroProntuarioDto) {

		Optional<Paciente> paciente = pacienteRepository.findByCpf(cadastroProntuarioDto.getPaciente().getCpf());

		if (paciente.isEmpty()) {
			paciente = Optional.of(cadastrarPaciente(cadastroProntuarioDto.getPaciente()));
		}

		Long idConsulta = cadastrarConsulta(new ConsultaDTO(cadastroProntuarioDto.getMedico(), paciente.get().getId()));

		cadastrarAtendimento(new AtendimentoDTO(LocalDate.now(), cadastroProntuarioDto.getPeso(),
				cadastroProntuarioDto.getAltura(), idConsulta));

		Prontuario prontuario = new Prontuario();

		prontuario.setPaciente(paciente.get());

		prontuarioRepository.save(prontuario);

		return prontuario.getId();
	}

	@Override
	public ConsultaProntuarioDTO consultarProntuario(PessoaDocumentoDTO pessoaDocumentoDto) {

		Optional<Atendimento> atendimento = atendimentoRepository.consultar(pessoaDocumentoDto.getCpf());
		if (atendimento.isPresent()) {
			return new ConsultaProntuarioDTO(atendimento.get());
		}
		throw new RegraNegocioException("Não existe paciente cadastrado para este cpf");
	}

	@Override
	public Long cadastrarConsulta(ConsultaDTO consultaDto) {

		if (consultaDto.getMedico() > 0L && consultaDto.getPaciente() > 0L) {
			Medico medico = new Medico();
			Paciente paciente = new Paciente();
			Consulta consulta = new Consulta();

			medico.setId(consultaDto.getMedico());
			paciente.setId(consultaDto.getPaciente());

			consulta.setMedico(medico);
			consulta.setPaciente(paciente);

			return consultaRepository.save(consulta).getId();
		}

		throw new RegraNegocioException("É necessário informar o médico e o paciente.");

	}

	@Override
	public Long cadastrarAtendimento(AtendimentoDTO atendimentoDto) {

		if (atendimentoDto.getConsulta() > 0L) {

			Consulta consulta = new Consulta();

			consulta.setId(atendimentoDto.getConsulta());

			Atendimento atendimento = new Atendimento();

			atendimento.setAltura(atendimentoDto.getAltura());
			atendimento.setPeso(atendimentoDto.getPeso());
			atendimento.setDataAtendimento(atendimentoDto.getDataAgendamento());
			atendimento.setConsulta(consulta);

			return atendimentoRepository.save(atendimento).getId();
		}

		throw new RegraNegocioException("É necessário informar uma consulta válida.");

	}

	@Override
	public void gerarDocumentoPDF() {

	}

	private Paciente cadastrarPaciente(PacienteDTO pacienteDto) {
		if (!ValidatorDocumentUseful.validarCpf(pacienteDto.getCpf()))
			throw new RegraNegocioException("CPF Inválido.");

		Paciente paciente = new Paciente();

		paciente.setNome(pacienteDto.getNome());
		paciente.setEmail(pacienteDto.getEmail());
		paciente.setCpf(pacienteDto.getCpf());
		paciente.setSexo(pacienteDto.getSexo());
		paciente.setDataNascimento(pacienteDto.getDataNascimento());
		paciente.setNomeMae(pacienteDto.getNomeMae());
		paciente.setNomePai(pacienteDto.getNomePai());

		return pacienteRepository.save(paciente);
	}
}
