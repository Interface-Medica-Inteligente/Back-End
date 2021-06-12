package br.ufs.dcomp.interfacemedicainteligente.service;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;

public interface MedicoService {
    Medico cadastrar(MedicoDTO medicoDTO);
}
