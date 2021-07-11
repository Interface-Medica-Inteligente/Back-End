package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.CID10;

public interface CIDRepository extends JpaRepository<CID10, Long> {

	Optional<CID10> findByCodigo(String codigoCid10);
}
