package br.ufs.dcomp.interfacemedicainteligente.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    
    @Query("SELECT rec FROM Receita rec JOIN FETCH rec.atendimento atd "
            + " WHERE atd.id = :idAtendimento ")
    Optional<Receita> findByIdAtendimento(@Param("idAtendimento") Long idAtendimento);

    @Query(value=" SELECT * FROM receita rec "
                + " JOIN atendimento atd ON (atd.id_atendimento = rec.id_atendimento) " 
                + " JOIN consulta con ON (con.id_consulta = atd.id_consulta) "
                + " JOIN paciente pac ON (pac.id_pessoa = con.id_paciente) "
                + " JOIN prescricao pre ON (pre.id_receita = rec.id_receita) "
                + " JOIN medicamento med ON (med.id_medicamento = pre.id_medicamento) "
                + " WHERE pac.id_pessoa = :idPaciente ", nativeQuery=true)
    Optional<Receita> findByIdPaciente(@Param("idPaciente") Long idPaciente);

    @Query(value=" SELECT * FROM receita rec "
                + " JOIN atendimento atd ON (atd.id_atendimento = rec.id_atendimento) " 
                + " JOIN prescricao pre ON (pre.id_receita = rec.id_receita) "
                + " JOIN medicamento med ON (med.id_medicamento = pre.id_medicamento) "
                + " WHERE med.nome = :medicamento AND atd.id_atendimento = :idAtendimento ", nativeQuery=true)
    Optional<Receita> findByFiltro(String medicamento, Long idAtendimento);
}
