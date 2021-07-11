package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PrescricaoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ReceitaDTO;

public interface ReceitaService {

    List<ReceitaDTO> consultarReceita();

    Long cadastrarPrescricao(PrescricaoDTO prescricaoDto);

}
