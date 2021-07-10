package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.RegistroCID10;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RegistroCID10DTO {

	private Long cid10;

	private Long registroAtendimento;

	public RegistroCID10DTO(RegistroCID10 registroCID10) {
		this.cid10 = registroCID10.getCid10().getId();
		this.registroAtendimento = registroCID10.getRegistroAtendimento().getId();
	}
}
