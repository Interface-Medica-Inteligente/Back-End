package br.ufs.dcomp.interfacemedicainteligente.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.MedicoAutenticarCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.MedicoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.PessoaDocumentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@GetMapping("/find-all")
	@ResponseStatus(OK)
	public List<MedicoDTO> findAll() {
		return medicoService.findAll();
	}

	@GetMapping("/find-by-id/{idMedico}")
	@ResponseStatus(OK)
	public MedicoDTO findById(@PathVariable Long idMedico) {
		return medicoService.findById(idMedico);
	}

	@PostMapping("/autenticar")
	@ResponseStatus(OK)
	public Long autenticar(@RequestBody MedicoAutenticarCmd medicoAutenticarCmd) {
		return medicoService.autenticar(medicoAutenticarCmd);
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public Long cadastar(@RequestBody MedicoCmd medicoDto) {
		return medicoService.cadastrar(medicoDto);
	}

	@PostMapping("/consultar-medico")
	@ResponseStatus(OK)
	public MedicoDTO consultar(@RequestBody PessoaDocumentoCmd cpf) {
		return medicoService.consultar(cpf);
	}
}
