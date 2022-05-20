package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import java.time.LocalDate;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class AtendimentoCmd {

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataAgendamento;

	private double peso;

	private double altura;

	@Min(value = 1, message = "Identificador de consulta inválido.")
	private Long consulta;
}
