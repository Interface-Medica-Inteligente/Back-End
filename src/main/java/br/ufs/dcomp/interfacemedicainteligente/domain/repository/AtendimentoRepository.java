package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

	@Query("SELECT DISTINCT obj FROM Atendimento obj JOIN FETCH obj.products "
			+ " WHERE obj.status = 0 ORDER BY obj.moment ASC")
	public List<Atendimento> consultar(String documentoPaciente);
}
