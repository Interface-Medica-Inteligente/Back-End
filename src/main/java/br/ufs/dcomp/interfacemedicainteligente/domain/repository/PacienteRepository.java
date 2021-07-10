package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	Optional<Paciente> findByCpf(String documentoPaciente);
}
