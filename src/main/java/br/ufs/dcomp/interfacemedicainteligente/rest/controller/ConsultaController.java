package br.ufs.dcomp.interfacemedicainteligente.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.AtendimentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CadastroProntuarioDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaProntuarioDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PessoaDocumentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@PostMapping("/cadastrar-prontuario")
	@ResponseStatus(CREATED)
	public Long cadastrarProntuario(@RequestBody CadastroProntuarioDTO cadastroProntuarioDto) {
		return consultaService.cadastrarProntuario(cadastroProntuarioDto);
	}

	@PostMapping("/consultar-prontuario")
	@ResponseStatus(OK)
	public ConsultaProntuarioDTO consultarProntuario(@RequestBody PessoaDocumentoDTO cpf) {
		return consultaService.consultarProntuario(cpf);
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

}
