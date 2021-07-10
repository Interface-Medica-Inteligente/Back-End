package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CID10DTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CNESDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RegistroAtendimentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RegistroCID10DTO;

public interface RegistroAtendimentoService {

	public Long cadastrarRegistroCid(RegistroCID10DTO registroCID10Dto);

	public List<RegistroCID10DTO> consultarRegistroCid();

	public Long cadastrarRegistroAtendimento(RegistroAtendimentoDTO registroAtendimentoDto);

	public List<RegistroAtendimentoDTO> consultarRegistroAtendimento();

	public Long cadastrarCid(CID10DTO cid10Dto);

	public List<CID10DTO> consultarCid();

	public Long cadastrarCnes(CNESDTO cnesDto);

	public List<CNESDTO> consultarCnes();
}
