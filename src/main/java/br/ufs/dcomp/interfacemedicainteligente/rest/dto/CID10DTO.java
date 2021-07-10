package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.CID10;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CID10DTO {

	private String codigo;
	
	private String descricao;

	public CID10DTO(CID10 cid) {
		this.codigo = cid.getCodigo();
		this.descricao = cid.getDescricao();
	}
}
