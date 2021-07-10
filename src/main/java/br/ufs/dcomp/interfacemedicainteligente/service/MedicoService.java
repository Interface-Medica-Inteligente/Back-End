package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoAtenticarDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;

public interface MedicoService {

	List<MedicoDTO> findAll();

	MedicoDTO findById(long idMedico);

	Long authenticate(MedicoAtenticarDTO medicoAutenticarDto);
	
    Long cadastrar(MedicoDTO medicoDto);

	Long editar(long id, MedicoDTO medicoDto);

	MedicoDTO consultar(String cpf);
}
