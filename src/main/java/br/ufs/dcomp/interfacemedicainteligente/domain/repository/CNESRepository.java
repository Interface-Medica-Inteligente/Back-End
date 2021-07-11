package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.CNES;

public interface CNESRepository extends JpaRepository<CNES, Long> {

	Optional<CNES> findByCodigo(Integer codigoCnes);
}
