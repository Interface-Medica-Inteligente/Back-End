package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Paciente;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {

	Optional<Prontuario> findByPaciente(Paciente paciente);

}