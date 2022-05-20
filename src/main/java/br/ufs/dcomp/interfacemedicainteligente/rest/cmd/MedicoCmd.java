package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoCmd {

	@NotBlank(message = "É necessário informar a senha.")
	private String senha;

	@NotBlank(message = "É necessário informar o crm.")
	private String crm;

	@NotBlank(message = "É necessário informar o nome.")
	private String nome;

	@NotBlank(message = "É necessário informar o email.")
	private String email;

	@NotBlank(message = "É necessário informar o cpf.")
	@Pattern(regexp = "[0-9]{11}", message = "CPF inválido.")
	private String cpf;

	@NotNull(message = "É necessário informar o sexo.")
	private char sexo;
}
