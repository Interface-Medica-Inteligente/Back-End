package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Receita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ReceitaDTO {

	String descricao;
	Boolean segunda_via;

	public ReceitaDTO(Receita receita) {
		this.descricao = receita.getDescricao();
		this.segunda_via = receita.getSegundaVia();
	}
}
