package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.AtendimentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PacienteDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PessoaDocumentoDTO;

public interface ConsultaService {

	public Long cadastrarPaciente(PacienteDTO paciente);

	public PacienteDTO consultarPaciente(PessoaDocumentoDTO cpf);

	public Long editarPaciente(PacienteDTO paciente);

	public Long cadastrarConsulta(ConsultaDTO consultaDTO);

	public Long cadastrarAtendimento(AtendimentoDTO atendimentoDTO);

	public List<AtendimentoDTO> consultar(PessoaDocumentoDTO documentoPaciente);

	public void gerarDocumentoPDF();
}
