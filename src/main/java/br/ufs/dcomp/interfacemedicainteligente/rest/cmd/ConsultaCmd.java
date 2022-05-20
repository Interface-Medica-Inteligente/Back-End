package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConsultaCmd {

	@Min(value = 1, message = "Identificador de médico inválido.")
	private Long medico;

	@Min(value = 1, message = "Identificador de paciente inválido.")
	private Long paciente;
}
