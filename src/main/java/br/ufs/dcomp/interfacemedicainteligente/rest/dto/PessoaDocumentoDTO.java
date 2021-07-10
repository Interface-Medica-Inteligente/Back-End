package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PessoaDocumentoDTO {

	private String documentoPessoa;

	@JsonCreator
	public PessoaDocumentoDTO(@JsonProperty("documentoPessoa") String documentoPessoa) {
		this.documentoPessoa = documentoPessoa;
	}

}
