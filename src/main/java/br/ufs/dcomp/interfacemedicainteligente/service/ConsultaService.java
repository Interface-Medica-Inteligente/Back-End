package br.ufs.dcomp.interfacemedicainteligente.service;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.AtendimentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CadastroProntuarioDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaProntuarioDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PessoaDocumentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RelatorioLaudoDTO;

public interface ConsultaService {

	public Long cadastrarProntuario(CadastroProntuarioDTO cadastroProntuarioDTO);

	public ConsultaProntuarioDTO consultarProntuario(PessoaDocumentoDTO pessoaDocumentoDto);

	public byte[] gerarDocumentoLaudoPDF(RelatorioLaudoDTO relatorioProntuarioDto);
	
	public Long cadastrarConsulta(ConsultaDTO consultaDto);

	public Long cadastrarAtendimento(AtendimentoDTO atendimentoDto);
}
