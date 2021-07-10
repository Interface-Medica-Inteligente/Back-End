package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    
    @Query(value=" select m from Medicamento m where m.nome like %:nome%")
    List<Medicamento> ConsultarPorNome(@Param("nome") String nome);
}
