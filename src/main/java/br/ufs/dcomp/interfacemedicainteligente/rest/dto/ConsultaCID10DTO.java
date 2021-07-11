package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ConsultaCID10DTO {

	private String codigoCid10;

	@JsonCreator
	public ConsultaCID10DTO(@JsonProperty("codigoCid10") String codigoCid10) {
		this.codigoCid10 = codigoCid10;
	}
}
