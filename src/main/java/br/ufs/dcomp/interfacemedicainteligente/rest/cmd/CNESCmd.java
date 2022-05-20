package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CNESCmd {

	@Min(value = 1, message = "Código é obrigatório.")
	private int codigo;
	
	@NotBlank(message = "Nome do estabelecimento é obrigatório.")
	private String nomeEstabelecimento;
}
