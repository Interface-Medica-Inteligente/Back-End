package br.ufs.dcomp.interfacemedicainteligente.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.MedicoRepository;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    @Transactional
    public Medico cadastrar(MedicoDTO medicoDto){
        
        Medico medico = new Medico();

        medico.setNome(medicoDto.getNome());
        medico.setCpf(medicoDto.getCpf());
        medico.setEmail(medicoDto.getEmail());
        medico.setSexo(medicoDto.getSexo());
        medico.setCrm(medicoDto.getCrm());
        medico.setSenha(medicoDto.getSenha());

        medicoRepository.save(medico);
        
        return medico;
    }

}
