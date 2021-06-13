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

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoAtenticarDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@GetMapping("/findAll")
	@ResponseStatus(OK)
	public List<MedicoDTO> findAll() {
		return medicoService.findAll();
	}

	@GetMapping("/findById/{idMedico}")
	@ResponseStatus(OK)
	public MedicoDTO findById(@PathVariable long idMedico) {
		return medicoService.findById(idMedico);
	}

	@GetMapping("/authenticate")
	@ResponseStatus(OK)
	public Long authenticate(@RequestBody MedicoAtenticarDTO medicoAutenticarDTO) {
		return medicoService.authenticate(medicoAutenticarDTO);
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public Long cadastar(@RequestBody MedicoDTO medicoDto) {
		return medicoService.cadastrar(medicoDto);
	}
}
