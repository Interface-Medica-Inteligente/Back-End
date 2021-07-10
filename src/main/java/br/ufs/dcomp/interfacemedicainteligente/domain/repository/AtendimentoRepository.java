package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

	@Query("SELECT DISTINCT atd FROM Atendimento atd JOIN FETCH atd.consulta con "
			+ "JOIN FETCH con.paciente pac "
			+ " WHERE pac.cpf = :cpf")
	public List<Atendimento> consultar(@Param("cpf") String documentoPaciente);
}
