package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.AtendimentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PacienteDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PessoaDocumentoDTO;

public interface ConsultaService {

	public Long cadastrarPaciente(PacienteDTO pacienteDto);

	public PacienteDTO consultarPaciente(PessoaDocumentoDTO pessoaDocumentoDto);

	public Long editarPaciente(PacienteDTO pacienteDto);

	public Long cadastrarConsulta(ConsultaDTO consultaDto);

	public Long cadastrarAtendimento(AtendimentoDTO atendimentoDto);

	public List<AtendimentoDTO> consultarAtendimento(PessoaDocumentoDTO PessoaDocumentoDto);

	public void gerarDocumentoPDF();
}
