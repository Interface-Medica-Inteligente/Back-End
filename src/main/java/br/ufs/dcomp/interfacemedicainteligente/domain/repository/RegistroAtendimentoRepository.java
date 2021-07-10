package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.RegistroAtendimento;

public interface RegistroAtendimentoRepository extends JpaRepository<RegistroAtendimento, Long> {

}
