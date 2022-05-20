package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CadastroRegistroCid10Cmd {

	@Min(value = 1, message = "Identificador de CID10 inválido.")
	private Long cid10;

	@Min(value = 1, message = "Identificador do registro de atendimento inválido.")
	private Long registroAtendimento;
}
