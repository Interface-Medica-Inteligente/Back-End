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
	public Long cadastrarCid(@RequestBody CID10DTO cid10Dto) {
		return registroAtendimentoService.cadastrarCid(cid10Dto);
	}

	@GetMapping("/consultar-cid")
	@ResponseStatus(OK)
	public List<CID10DTO> consultarCid() {
		return registroAtendimentoService.consultarCid();
	}

	@PostMapping("/cadastrar-cnes")
	@ResponseStatus(CREATED)
	public Long cadastrarCnes(@RequestBody CNESDTO cnesDto) {
		return registroAtendimentoService.cadastrarCnes(cnesDto);
	}

	@GetMapping("/consultar-cnes")
	@ResponseStatus(OK)
	public List<CNESDTO> consultarCnes() {
		return registroAtendimentoService.consultarCnes();
	}

	@PostMapping("/cadastrar-registro-atendimento")
	@ResponseStatus(CREATED)
	public Long cadastrarRegistroAtendimento(@RequestBody RegistroAtendimentoDTO registroAtendimentoDto) {
		return registroAtendimentoService.cadastrarRegistroAtendimento(registroAtendimentoDto);
	}

	@PostMapping("/cadastrar-registro-cid10")
	@ResponseStatus(CREATED)
	public Long cadastrarRegistroCid(@RequestBody RegistroCID10DTO registroCID10Dto) {
		return registroAtendimentoService.cadastrarRegistroCid(registroCID10Dto);
	}

	@GetMapping("/consultar-registro-cid10")
	@ResponseStatus(OK)
	public List<RegistroCID10DTO> consultarRegistroCid() {
		return registroAtendimentoService.consultarRegistroCid();
	}
}
