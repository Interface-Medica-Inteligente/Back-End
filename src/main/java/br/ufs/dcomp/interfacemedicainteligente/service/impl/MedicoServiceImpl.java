package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.MedicoRepository;
import br.ufs.dcomp.interfacemedicainteligente.exception.RegraNegocioException;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.MedicoService;
import br.ufs.dcomp.interfacemedicainteligente.service.ValidatorService;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    @Transactional
    public Integer cadastrar(MedicoDTO medicoDto){

        if(!ValidatorService.validarCpf(medicoDto.getCpf())) 
            throw new RegraNegocioException("CPF Inválido.");
        
        Medico medico = new Medico();

        medico.setNome(medicoDto.getNome());
        medico.setCpf(medicoDto.getCpf());
        medico.setEmail(medicoDto.getEmail());
        medico.setSexo(medicoDto.getSexo());
        medico.setCrm(medicoDto.getCrm());
        medico.setSenha(medicoDto.getSenha());

        medicoRepository.save(medico);
        
        return medico.getId();
    }
    
}
