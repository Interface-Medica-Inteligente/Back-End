package br.ufs.dcomp.interfacemedicainteligente.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoAtenticarDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@GetMapping("/findAll")
	public ResponseEntity<List<MedicoDTO>> finAll() {
		return ResponseEntity.ok().body(medicoService.findAll());
	}

	@GetMapping("/findById/{idMedico}")
	public ResponseEntity<MedicoDTO> findById(@PathVariable long idMedico) {
		return ResponseEntity.ok().body(medicoService.findById(idMedico));
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public Long cadastarMedico(@RequestBody MedicoDTO medicoDto) {
		Medico medico = medicoService.cadastrar(medicoDto);
		return medico.getId();
	}

	@GetMapping("/authenticate")
	public ResponseEntity<Long> authenticate(@RequestBody MedicoAtenticarDTO medicoAutenticar) {
		return ResponseEntity.ok().body(medicoService.authenticate(medicoAutenticar));
	}
}
