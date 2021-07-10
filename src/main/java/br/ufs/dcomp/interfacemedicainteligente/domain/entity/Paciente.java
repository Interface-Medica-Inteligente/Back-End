package br.ufs.dcomp.interfacemedicainteligente.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="paciente")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Paciente extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(name="data_nascimento")
    private LocalDate dataNascimento;

    @Column(name="nome_mae")
    private String nomeMae;

    @Column(name="nome_pai")
    private String nomePai;

}
