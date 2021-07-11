package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class FiltroReceitaDTO {
    
    private Long atendimento;

    private String medicamento;
}
