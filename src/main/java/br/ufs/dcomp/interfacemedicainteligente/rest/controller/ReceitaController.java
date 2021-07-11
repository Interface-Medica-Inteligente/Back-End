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

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PrescricaoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ReceitaDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.ReceitaService;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    ReceitaService receitaService;

    @GetMapping("consultar-receita")
    @ResponseStatus(OK)
    public List<ReceitaDTO> consultarReceita() {
        return receitaService.consultarReceita();
    }

    @PostMapping("/cadastrar-prescricao")
    @ResponseStatus(CREATED)
    public Long cadastrarPrescricao(@RequestBody PrescricaoDTO prescricaoDto) {
        return receitaService.cadastrarPrescricao(prescricaoDto);
    }
    
}
