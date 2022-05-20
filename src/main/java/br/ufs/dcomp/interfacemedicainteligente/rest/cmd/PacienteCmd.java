package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PacienteCmd {

	@NotBlank(message = "É necessário informar o nome.")
	private String nome;

	@NotBlank(message = "É necessário informar o email.")
	private String email;

	@NotBlank(message = "É necessário informar o cpf.")
	@Pattern(regexp = "[0-9]{11}", message = "CPF inválido.")
	private String cpf;

	@NotNull(message = "É necessário informar o sexo.")
	private char sexo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "É necessário informar a data de nascimento.")
	private LocalDate dataNascimento;

	@NotBlank(message = "É necessário informar o nome da mãe.")
	private String nomeMae;

	private String nomePai;
}
