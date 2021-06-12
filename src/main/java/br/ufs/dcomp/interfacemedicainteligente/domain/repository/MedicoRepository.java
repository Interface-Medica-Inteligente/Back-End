package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    
}