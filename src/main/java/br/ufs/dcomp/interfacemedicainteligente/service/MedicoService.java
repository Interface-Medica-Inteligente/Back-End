package br.ufs.dcomp.interfacemedicainteligente.service;

import java.util.List;

import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.MedicoAutenticarCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.MedicoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.PessoaDocumentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;

public interface MedicoService {

	List<MedicoDTO> findAll();

	MedicoDTO findById(long idMedico);

	Long autenticar(MedicoAutenticarCmd medicoAutenticarCmd);

	Long cadastrar(MedicoCmd medicoDto);

	MedicoDTO consultar(PessoaDocumentoCmd pessoaDocumentoCmd);
}
