package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CID10Cmd {

	@NotBlank(message = "O código é obrigatório.")
	private String codigo;
	
	@NotBlank(message = "Descrição é obrigatória.")
	private String descricao;
}
