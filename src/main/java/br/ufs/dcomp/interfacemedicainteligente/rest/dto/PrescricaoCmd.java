package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.MedicamentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.ReceitaCmd;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PrescricaoCmd {

	@NotBlank(message = "É necessário informar a quantidade de uso.")
	private String quantidadeUso;

	@Min(value = 1, message = "É necessário informar a quantidade diária.")
	private Integer quantidadeDiaria;

	@Valid
	@NotNull(message = "É necessário informar o medicamento.")
	private MedicamentoCmd medicamento;

	@Valid
	@NotNull(message = "É necessário informar a receita.")
	private ReceitaCmd receita;
}
