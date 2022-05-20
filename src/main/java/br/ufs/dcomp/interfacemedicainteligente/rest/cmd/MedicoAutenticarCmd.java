package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MedicoAutenticarCmd {

	@NotBlank(message = "É necessário informar o email.")
	private String email;

	@NotBlank(message = "É necessário informar a senha.")
	private String senha;
}
