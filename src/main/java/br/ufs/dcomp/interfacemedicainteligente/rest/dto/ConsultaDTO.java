package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Consulta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConsultaDTO {

	private Long idMedico;

	private Long idPaciente;

	public ConsultaDTO(Consulta consulta) {
		this.idPaciente = consulta.getPaciente().getId();
		this.idMedico = consulta.getMedico().getId();
	}
}
