package br.ufs.dcomp.interfacemedicainteligente.rest.cmd;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class RelatorioLaudoCmd {

	@NotBlank(message = "Código do CNES é obrigatório.")
	private String codigoCnes;

	@NotBlank(message = "Nome do estabelecimento é obrigatório.")
	private String nomeEstabelecimento;

	@NotBlank(message = "Nome do paciente é obrigatório.")
	private String nomePaciente;

	@NotBlank(message = "Nome da mãe é obrigatório.")
	private String nomeMae;

	@NotBlank(message = "Peso é obrigatório.")
	private String peso;

	@NotBlank(message = "Altura é obrigatória.")
	private String altura;

	@NotBlank(message = "Código do CID é obrigatório.")
	private String codigoCid10;

	@NotBlank(message = "Diagnóstico é obrigatório.")
	private String diagnostico;

	@NotBlank(message = "Anamnese é obrigatória.")
	private String anamnese;

	@NotBlank(message = "Consulta prévia é obrigatória.")
	private String consultaPrevia;
}
