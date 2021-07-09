package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    
}
