package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CID10DTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CNESDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RegistroAtendimentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RegistroCID10DTO;

public interface RegistroAtendimentoService {

	public Long cadastrarRegistroCID10(RegistroCID10DTO registroCID10DTO);

	public List<RegistroCID10DTO> consultarRegistroCID10();

	public Long cadastrar(RegistroAtendimentoDTO registroAtendimentoDTO);

	public List<RegistroAtendimentoDTO> consultar();

	public Long cadastrarCID10(CID10DTO cid10DTO);

	public List<CID10DTO> consultarCID10();

	public Long cadastrarCNES(CNESDTO cnesDTO);

	public List<CNESDTO> consultarCNES();
}
