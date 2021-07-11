package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

	@Query("SELECT DISTINCT atd FROM Atendimento as atd "
			+ " WHERE atd.id = (SELECT MAX(atn.id) FROM Atendimento as atn INNER JOIN atn.consulta as con "
			+ " INNER JOIN con.paciente as pac WHERE pac.cpf = :cpf)")
	public Optional<Atendimento> consultar(@Param("cpf") String documentoPaciente);
}
