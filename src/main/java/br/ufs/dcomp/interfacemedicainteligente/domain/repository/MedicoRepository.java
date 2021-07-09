package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    
	Optional<Medico> findByEmail(String email);

	Optional<Medico> findByCpf(String cpf);
	
}