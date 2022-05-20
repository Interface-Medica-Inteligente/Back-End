package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RelatorioReceitaDTO {

	private String nomePaciente;

	private String medicamento;

	private String quantidade;

	private String uso;

	private String descricao;

	private String via;

	private String dataEmissao;

}
