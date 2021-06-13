package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoAtenticarDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;

public interface MedicoService {

	List<MedicoDTO> findAll();

	MedicoDTO findById(long idMedico);

	Medico cadastrar(MedicoDTO medicoDTO);

	Long authenticate(MedicoAtenticarDTO medicoAutenticar);
}
