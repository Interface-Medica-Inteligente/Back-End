package br.ufs.dcomp.interfacemedicainteligente.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.AtendimentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PacienteDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PessoaDocumentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@PostMapping("/cadastrar-paciente")
	@ResponseStatus(CREATED)
	public Long cadastrarPaciente(@RequestBody PacienteDTO pacienteDto) {
		return consultaService.cadastrarPaciente(pacienteDto);
	}

	@PostMapping("/consultar-paciente")
	@ResponseStatus(OK)
	public PacienteDTO consultarPaciente(@RequestBody PessoaDocumentoDTO cpf) {
		return consultaService.consultarPaciente(cpf);
	}

	@PostMapping("/cadastrar-consulta")
	@ResponseStatus(CREATED)
	public Long cadastrarConsulta(@RequestBody ConsultaDTO consultaDto) {
		return consultaService.cadastrarConsulta(consultaDto);
	}

	@PostMapping("/cadastrar-atendimento")
	@ResponseStatus(CREATED)
	public Long cadastrarAtendimento(@RequestBody AtendimentoDTO atendimentoDto) {
		return consultaService.cadastrarAtendimento(atendimentoDto);
	}

	@PostMapping("/consultar")
	@ResponseStatus(OK)
	public List<AtendimentoDTO> consultarAtendimento(@RequestBody PessoaDocumentoDTO pessoaDocumentoDto) {
		return consultaService.consultarAtendimento(pessoaDocumentoDto);
	}
}
