package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PessoaDocumentoDTO {

	private String cpf;

	@JsonCreator
	public PessoaDocumentoDTO(@JsonProperty("cpf") String cpf) {
		this.cpf = cpf;
	}

}
