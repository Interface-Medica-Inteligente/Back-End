package br.ufs.dcomp.interfacemedicainteligente.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.MedicoService;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {
    
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer cadastar(@RequestBody MedicoDTO medicoDto) {
        return medicoService.cadastrar(medicoDto);
    }
}
