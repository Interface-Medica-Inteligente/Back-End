package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CadastroProntuarioCmd {

	@Valid
	@NotNull(message = "É necessário informar os dados do paciente.")
	private PacienteCmd paciente;

	@Min(value = 1, message = "Identificador do médico inválido.")
	private Long medico;

	@Min(value = 1, message = "Peso inválido.")
	private double peso;

	@Min(value = 1, message = "Altura inválida.")
	private double altura;
}
