package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaCmd {

	@NotBlank(message = "É necessário informar a descrição.")
	private String descricao;

	@NotNull(message = "É necessário informar se é um segunda via.")
	private Boolean segundaVia;

	@Min(value = 1, message = "Identificador de atendimento inválido.")
	private Long atendimento;

}
