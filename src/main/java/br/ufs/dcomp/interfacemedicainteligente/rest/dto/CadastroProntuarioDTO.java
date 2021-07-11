package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CadastroProntuarioDTO {

	private AtendimentoDTO atendimento;
	private ConsultaDTO consulta;
	private PacienteDTO paciente;

}
