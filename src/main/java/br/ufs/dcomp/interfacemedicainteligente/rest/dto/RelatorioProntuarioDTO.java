package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RelatorioProntuarioDTO {

	private String nome;

	private String email;

	private String cpf;

	private String sexo;

	private String dataNascimento;

	private String nomeMae;

	private String nomePai;

	private String nomeMedico;

	private String peso;

	private String altura;

}
