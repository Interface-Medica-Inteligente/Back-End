package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Consulta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConsultaDTO {

	private MedicoDTO medicoDTO;

	private PacienteDTO pacienteDTO;

	public ConsultaDTO(Consulta consulta) {
		this.pacienteDTO = new PacienteDTO(consulta.getPaciente());
		this.medicoDTO = new MedicoDTO(consulta.getMedico());
	}
}
