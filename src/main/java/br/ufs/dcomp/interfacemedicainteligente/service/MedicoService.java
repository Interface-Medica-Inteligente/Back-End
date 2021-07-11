package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoAtenticarDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PessoaDocumentoDTO;

public interface MedicoService {

	List<MedicoDTO> findAll();

	MedicoDTO findById(long idMedico);

	Long autenticar(MedicoAtenticarDTO medicoAutenticarDto);
	
    Long cadastrar(MedicoDTO medicoDto);

	MedicoDTO consultar(PessoaDocumentoDTO pessoaDocumentoDto);
}
