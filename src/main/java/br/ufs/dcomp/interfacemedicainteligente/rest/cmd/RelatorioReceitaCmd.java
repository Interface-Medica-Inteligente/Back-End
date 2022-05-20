package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RelatorioReceitaCmd {

	@NotBlank(message = "Nome do paciente é obrigatório.")
	private String nomePaciente;

	@NotBlank(message = "Medicamento é obrigatório.")
	private String medicamento;

	@NotBlank(message = "Quantidade é obrigatória.")
	private String quantidade;

	@NotBlank(message = "O uso é obrigatório.")
	private String uso;

	@NotBlank(message = "A descrição é obrigatória.")
	private String descricao;

	@NotBlank(message = "A via é obrigatória.")
	private String via;

	private String dataEmissao;
}
