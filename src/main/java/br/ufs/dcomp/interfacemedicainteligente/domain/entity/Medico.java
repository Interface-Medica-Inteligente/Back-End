package br.ufs.dcomp.interfacemedicainteligente.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="medico")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Medico extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String senha;

    private String crm;

	@JsonIgnore
	@OneToMany(mappedBy="medico", fetch=FetchType.LAZY)
	private List<Consulta> consultas;
}
