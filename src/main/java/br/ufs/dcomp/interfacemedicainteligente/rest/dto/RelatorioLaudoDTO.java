package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RelatorioLaudoDTO {

	private String codigoCnes;

	private String nomeEstabelecimento;

	private String nomePaciente;

	private String nomeMae;

	private String peso;

	private String altura;

	private String codigoCid10;

	private String diagnostico;

	private String anamnese;

	private String consultaPrevia;
}
