package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ConsultaCID10Cmd {

	@NotBlank(message = "Código do Cid é obrigatório.")
	private String codigoCid10;

	@JsonCreator
	public ConsultaCID10Cmd(@JsonProperty("codigoCid10") String codigoCid10) {
		this.codigoCid10 = codigoCid10;
	}
}
