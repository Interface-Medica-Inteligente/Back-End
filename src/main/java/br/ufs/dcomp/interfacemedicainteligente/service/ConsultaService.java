package br.ufs.dcomp.interfacemedicainteligente.service;

import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CadastroProntuarioCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.PessoaDocumentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.RelatorioLaudoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.RelatorioReceitaCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaProntuarioDTO;

public interface ConsultaService {

	public Long cadastrarProntuario(CadastroProntuarioCmd cadastroProntuarioCmd);

	public ConsultaProntuarioDTO consultarProntuario(PessoaDocumentoCmd pessoaDocumentoCmd);

	public byte[] gerarDocumentoLaudoPDF(RelatorioLaudoCmd relatorioLaudoCmd);

	public byte[] gerarDocumentoReceitaPDF(RelatorioReceitaCmd relatorioReceitaCmd);
}
