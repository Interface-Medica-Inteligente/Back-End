package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDocumentoCmd {

	@NotBlank(message = "É necessário informar o cpf.")
	@Pattern(regexp = "[0-9]{11}", message = "CPF inválido.")
	private String cpf;

	@JsonCreator
	public PessoaDocumentoCmd(@JsonProperty("cpf") String cpf) {
		this.cpf = cpf;
	}
}
