package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Consulta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaDTO {

	private Long medico;

	private Long paciente;

	public ConsultaDTO(Consulta consulta) {
		this.paciente = consulta.getPaciente().getId();
		this.medico = consulta.getMedico().getId();
	}
}
