package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.FiltroReceitaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.InformacaoReceitaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PrescricaoCmd;

public interface ReceitaService {

	List<InformacaoReceitaDTO> consultarReceitas(@PathVariable Long idPaciente);

	Long cadastrarPrescricao(PrescricaoCmd prescricaoCmd);

	List<InformacaoReceitaDTO> consultarReceitaPorFiltro(FiltroReceitaDTO filtroReceitaDto);

}
