package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import java.time.LocalDate;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Atendimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AtendimentoDTO {

	private LocalDate dataAgendamento;

	private double peso;

	private double altura;

	private ConsultaDTO consultaDTO;

	public AtendimentoDTO(Atendimento atendimento) {
		this.dataAgendamento = atendimento.getDataAtendimento();
		this.peso = atendimento.getPeso();
		this.altura = atendimento.getAltura();
		this.consultaDTO = new ConsultaDTO(atendimento.getConsulta());
	}
}
