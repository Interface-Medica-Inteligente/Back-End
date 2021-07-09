package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.RegistroAtendimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegistroAtendimentoDTO {

	private String estadoTratamento;

	private String anamneseProgessao;

	private boolean anamnese;

	private CNESDTO cnesDTO;

	public RegistroAtendimentoDTO(RegistroAtendimento registroAtendimento) {
		this.estadoTratamento = registroAtendimento.getEstadoTratamento();
		this.anamneseProgessao = registroAtendimento.getAnamneseProgressao();
		this.anamnese = registroAtendimento.getAnamnese();
		this.cnesDTO = new CNESDTO(registroAtendimento.getCnes());
	}

}
