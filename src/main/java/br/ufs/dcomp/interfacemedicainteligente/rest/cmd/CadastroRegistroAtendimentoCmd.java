package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CadastroRegistroAtendimentoCmd {

	@NotBlank(message = "Estado do tratamento é obrigatório.")
	private String estadoTratamento;

	@NotBlank(message = "Progressão da anamnese é obrigatório.")
	private String anamneseProgessao;

	private boolean anamnese;

	@Min(value = 1, message = "Identificador de cnes inválido.")
	private Long cnes;

	@Min(value = 1, message = "Identificador de atendimento inválido.")
	private Long atendimento;
}
