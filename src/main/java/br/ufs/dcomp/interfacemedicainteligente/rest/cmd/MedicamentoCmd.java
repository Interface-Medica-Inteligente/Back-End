package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicamentoCmd {

	@NotBlank(message = "É necessário informar o nome do medicamento.")
	private String nome;

	@JsonCreator
	public MedicamentoCmd(@JsonProperty("nome") String nome) {
		this.nome = nome;
	}
}
