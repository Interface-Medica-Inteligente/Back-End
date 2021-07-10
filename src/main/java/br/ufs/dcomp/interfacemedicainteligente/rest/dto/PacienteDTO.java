package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PacienteDTO {

	private String nome;

	private String email;

	private String cpf;

	private char sexo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	private String nomeMae;

	private String nomePai;

	public PacienteDTO(Paciente paciente) {
		this.nome = paciente.getNome();
		this.email = paciente.getEmail();
		this.cpf = paciente.getCpf();
		this.sexo = paciente.getSexo();
		this.dataNascimento = paciente.getDataNascimento();
		this.nomeMae = paciente.getNomeMae();
		this.nomePai = paciente.getNomePai();
	}
}
