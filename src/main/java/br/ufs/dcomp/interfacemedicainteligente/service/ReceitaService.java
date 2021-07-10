package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicamentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PrescricaoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ReceitaDTO;

public interface ReceitaService {
    Long cadastrarReceita(ReceitaDTO receitaDto);

    List<ReceitaDTO> consultarReceita();

    Long cadastrarPrescricao(PrescricaoDTO prescricaoDTO);

    List<PrescricaoDTO> consultarPrescricao();

    Long cadastrarMedicamento(MedicamentoDTO medicamentoDto);

    List<MedicamentoDTO> consultarMedicamento(MedicamentoDTO medicamentoDto);
}
