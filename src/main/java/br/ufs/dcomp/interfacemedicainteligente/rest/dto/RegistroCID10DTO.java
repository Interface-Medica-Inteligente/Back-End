package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.RegistroCID10;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RegistroCID10DTO {

	private Long idCID10;

	private Long idRegistroAtendimento;

	public RegistroCID10DTO(RegistroCID10 registroCID10) {
		this.idCID10 = registroCID10.getCid10().getId();
		this.idRegistroAtendimento = registroCID10.getRegistroAtendimento().getId();
	}
}
