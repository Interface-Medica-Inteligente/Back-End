package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Prescricao;

public interface PrescricaoRepository extends JpaRepository<Prescricao, Long>{
    
}
