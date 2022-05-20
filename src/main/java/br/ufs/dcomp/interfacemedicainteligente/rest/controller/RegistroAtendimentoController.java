package br.ufs.dcomp.interfacemedicainteligente.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CID10Cmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CNESCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CadastroRegistroAtendimentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CadastroRegistroCid10Cmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.ConsultaCID10Cmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CID10DTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CNESDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.RegistroAtendimentoService;

@RestController
@RequestMapping("/registro-atendimento")
public class RegistroAtendimentoController {

	@Autowired
	private RegistroAtendimentoService registroAtendimentoService;

	@PostMapping("/cadastrar-cid")
	@ResponseStatus(CREATED)
	public Long cadastrarCID10(@RequestBody CID10Cmd cid10Cmd) {
		return registroAtendimentoService.cadastrarCID10(cid10Cmd);
	}

	@GetMapping("/consultar-cid/{codigoCid10}")
	@ResponseStatus(OK)
	public CID10DTO consultarCID10(@PathVariable ConsultaCID10Cmd codigoCid10) {
		return registroAtendimentoService.consultarCID10(codigoCid10);
	}

	@PostMapping("/cadastrar-cnes")
	@ResponseStatus(CREATED)
	public Long cadastrarCnes(@RequestBody CNESCmd cnesCmd) {
		return registroAtendimentoService.cadastrarCnes(cnesCmd);
	}

	@GetMapping("/consultar-cnes/{codigoCnes}")
	@ResponseStatus(OK)
	public CNESDTO consultarCnes(@PathVariable Integer codigoCnes) {
		return registroAtendimentoService.consultarCnes(codigoCnes);
	}

	@PostMapping("/cadastrar-registro-atendimento")
	@ResponseStatus(CREATED)
	public Long cadastrarRegistroAtendimento(
			@RequestBody CadastroRegistroAtendimentoCmd cadastroRegistroAtendimentoCmd) {
		return registroAtendimentoService.cadastrarRegistroAtendimento(cadastroRegistroAtendimentoCmd);
	}

	@PostMapping("/cadastrar-registro-cid10")
	@ResponseStatus(CREATED)
	public Long cadastrarRegistroCid(@RequestBody CadastroRegistroCid10Cmd cadastroRegistroCid10Cmd) {
		return registroAtendimentoService.cadastrarRegistroCid(cadastroRegistroCid10Cmd);
	}
}
