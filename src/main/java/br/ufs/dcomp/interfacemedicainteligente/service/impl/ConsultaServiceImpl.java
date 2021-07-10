package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Atendimento;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Consulta;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Paciente;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Receita;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.AtendimentoRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.ConsultaRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.PacienteRepository;
import br.ufs.dcomp.interfacemedicainteligente.exception.RegraNegocioException;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.AtendimentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PacienteDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.ConsultaService;
import br.ufs.dcomp.interfacemedicainteligente.useful.ValidatorDocumentUseful;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private PacienteRepository pacienteRepositorio;

	@Autowired
	private AtendimentoRepository atendimentoRepositorio;

	@Autowired
	private ConsultaRepository consultaRepositorio;

	@Override
	public Long cadastrarPaciente(PacienteDTO pacienteDTO) {
		if (!ValidatorDocumentUseful.validarCpf(pacienteDTO.getCpf()))
			throw new RegraNegocioException("CPF Inválido.");

		Paciente paciente = new Paciente();

		paciente.setNome(pacienteDTO.getNome());
		paciente.setEmail(pacienteDTO.getEmail());
		paciente.setCpf(pacienteDTO.getCpf());
		paciente.setSexo(pacienteDTO.getSexo());
		paciente.setDataNascimento(pacienteDTO.getDataNascimento());
		paciente.setNomeMae(pacienteDTO.getNomeMae());
		paciente.setNomePai(pacienteDTO.getNomePai());

		return pacienteRepositorio.save(paciente).getId();
	}

	@Override
	public PacienteDTO consultarPaciente(String cpf) {

		Optional<Paciente> paciente = pacienteRepositorio.findByCpf(cpf);
		if (paciente.isPresent()) {
			return new PacienteDTO(paciente.get());
		}
		throw new RegraNegocioException("Não existe paciente cadastrado para este cpf");
	}

	@Override
	public Long editarPaciente(PacienteDTO paciente) {
		return null;
	}

	@Override
	public Long cadastrarConsulta(ConsultaDTO consultaDTO) {

		if (consultaDTO.getIdMedico() > 0L && consultaDTO.getIdPaciente() > 0L) {
			Medico medico = new Medico();
			Paciente paciente = new Paciente();
			Consulta consulta = new Consulta();

			medico.setId(consultaDTO.getIdMedico());
			paciente.setId(consultaDTO.getIdPaciente());

			consulta.setMedico(medico);
			consulta.setPaciente(paciente);

			return consultaRepositorio.save(consulta).getId();
		}

		throw new RegraNegocioException("É necessário informar o médico e o paciente.");

	}

	@Override
	public Long cadastrarAtendimento(AtendimentoDTO atendimentoDTO) {

		if (atendimentoDTO.getIdConsulta() > 0L && atendimentoDTO.getIdReceita() > 0L) {
			Consulta consulta = new Consulta();
			Receita receita = new Receita();

			consulta.setId(atendimentoDTO.getIdConsulta());
			receita.setId(atendimentoDTO.getIdReceita());

			Atendimento atendimento = new Atendimento();

			atendimento.setAltura(atendimentoDTO.getAltura());
			atendimento.setPeso(atendimentoDTO.getPeso());
			atendimento.setDataAtendimento(atendimentoDTO.getDataAgendamento());
			atendimento.setConsulta(consulta);
			atendimento.setReceita(receita);

			return atendimentoRepositorio.save(atendimento).getId();
		}

		throw new RegraNegocioException("É necessário informar uma consulta válida.");

	}

	@Override
	public List<AtendimentoDTO> consultar(String documentoPaciente) {
		List<Atendimento> listaAtendimento = atendimentoRepositorio.consultar(documentoPaciente);
		return listaAtendimento.stream().map(atendimento -> new AtendimentoDTO(atendimento))
				.collect(Collectors.toList());
	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub

	}

}
