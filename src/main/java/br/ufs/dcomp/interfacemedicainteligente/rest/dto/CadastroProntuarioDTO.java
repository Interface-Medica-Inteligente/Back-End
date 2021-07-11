package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CadastroProntuarioDTO {

	private PacienteDTO paciente;

	private Long medico;

	private double peso;

	private double altura;
}
