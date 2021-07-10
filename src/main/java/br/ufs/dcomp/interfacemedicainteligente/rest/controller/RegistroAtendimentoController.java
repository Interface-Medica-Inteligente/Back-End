package br.ufs.dcomp.interfacemedicainteligente.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CID10DTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CNESDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RegistroAtendimentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RegistroCID10DTO;
import br.ufs.dcomp.interfacemedicainteligente.service.RegistroAtendimentoService;

@RestController
@RequestMapping("/registro-atendimento")
public class RegistroAtendimentoController {

	@Autowired
	private RegistroAtendimentoService registroAtendimentoService;

	@PostMapping("/cadastrar-cid")
	@ResponseStatus(CREATED)
	public Long cadastrarCID10(@RequestBody CID10DTO cid10dto) {
		return registroAtendimentoService.cadastrarCID10(cid10dto);
	}

	@GetMapping("/consultar-cid")
	@ResponseStatus(OK)
	public List<CID10DTO> consultarCID10() {
		return registroAtendimentoService.consultarCID10();
	}

	@PostMapping("/cadastrar-cnes")
	@ResponseStatus(CREATED)
	public Long cadastrarCNES(@RequestBody CNESDTO cnesDTO) {
		return registroAtendimentoService.cadastrarCNES(cnesDTO);
	}

	@GetMapping("/consultar-cnes")
	@ResponseStatus(OK)
	public List<CNESDTO> consultarCNES() {
		return registroAtendimentoService.consultarCNES();
	}

	@PostMapping("/cadastrar")
	@ResponseStatus(CREATED)
	public Long cadastrar(@RequestBody RegistroAtendimentoDTO registroAtendimentoDTO) {
		return registroAtendimentoService.cadastrar(registroAtendimentoDTO);
	}

	@PostMapping("/cadastrar-registrocid10")
	@ResponseStatus(CREATED)
	public Long cadastrarRegistroCID10(@RequestBody RegistroCID10DTO registroCID10DTO) {
		return registroAtendimentoService.cadastrarRegistroCID10(registroCID10DTO);
	}

	@GetMapping("/consultar-registrocid10")
	@ResponseStatus(OK)
	public List<RegistroCID10DTO> consultarRegistroCID10() {
		return registroAtendimentoService.consultarRegistroCID10();
	}
}
