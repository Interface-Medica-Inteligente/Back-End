package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CID10Cmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CNESCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CadastroRegistroAtendimentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CadastroRegistroCid10Cmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.ConsultaCID10Cmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CID10DTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CNESDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RegistroCID10DTO;

public interface RegistroAtendimentoService {

	public Long cadastrarRegistroCid(CadastroRegistroCid10Cmd cadastroRegistroCid10Cmd);

	public List<RegistroCID10DTO> consultarRegistroCid();

	public Long cadastrarRegistroAtendimento(CadastroRegistroAtendimentoCmd cadastroRegistroAtendimentoCmd);

	public Long cadastrarCID10(CID10Cmd cid10Cmd);

	public CID10DTO consultarCID10(ConsultaCID10Cmd codigoCid10);

	public Long cadastrarCnes(CNESCmd cnesCmd);

	public CNESDTO consultarCnes(Integer codigoCnes);
}
