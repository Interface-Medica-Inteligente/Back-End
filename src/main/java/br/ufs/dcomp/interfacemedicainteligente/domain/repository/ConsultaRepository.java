package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
