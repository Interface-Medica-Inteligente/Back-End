package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PrescricaoDTO {

    private String quantidadeUso;

    private Integer quantidadeDiaria;
    
    private Long medicamento;

    private Long receita;
}
