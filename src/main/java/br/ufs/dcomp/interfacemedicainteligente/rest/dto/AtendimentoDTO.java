package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Atendimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoDTO {

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataAgendamento;

	private double peso;

	private double altura;

	private Long consulta;

	private Long receita;

	public AtendimentoDTO(Atendimento atendimento) {
		this.dataAgendamento = atendimento.getDataAtendimento();
		this.peso = atendimento.getPeso();
		this.altura = atendimento.getAltura();
		this.consulta = atendimento.getConsulta().getId();
		this.receita = atendimento.getReceita().getId();
	}
}
