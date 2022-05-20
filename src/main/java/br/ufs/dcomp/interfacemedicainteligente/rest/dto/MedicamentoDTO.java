package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medicamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicamentoDTO {

	private String nome;

	public MedicamentoDTO(String nome) {
		this.nome = nome;
	}

	public MedicamentoDTO(Medicamento medicamento) {
		nome = medicamento.getNome();
	}
}
