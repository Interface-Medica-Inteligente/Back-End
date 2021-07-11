package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import java.time.LocalDate;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Atendimento;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConsultaProntuarioDTO {

	private String nomePaciente;

	private String nomeMae;

	private String nomePai;

	private LocalDate dataNascimento;

	private double altura;

	private double peso;

	private String cpf;

	private char sexo;

	private Long idAtendimento;

	public ConsultaProntuarioDTO(Atendimento atendimento) {
		this.nomePaciente = atendimento.getConsulta().getPaciente().getNome();
		this.nomeMae = atendimento.getConsulta().getPaciente().getNomeMae();
		this.nomePai = atendimento.getConsulta().getPaciente().getNomePai();
		this.dataNascimento = atendimento.getConsulta().getPaciente().getDataNascimento();
		this.altura = atendimento.getAltura();
		this.peso = atendimento.getPeso();
		this.cpf = atendimento.getConsulta().getPaciente().getCpf();
		this.sexo = atendimento.getConsulta().getPaciente().getSexo();
		this.idAtendimento = atendimento.getId();
	}

}
