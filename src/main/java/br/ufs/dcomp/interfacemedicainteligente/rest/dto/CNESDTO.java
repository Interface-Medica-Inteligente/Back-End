package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.CNES;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CNESDTO {

	private int codigo;
	private String nomeEstabelecimento;
	
	public CNESDTO(CNES cnes) {
		this.codigo = cnes.getCodigo();
		this.nomeEstabelecimento = cnes.getNomeEstabelecimento();
	}
}
