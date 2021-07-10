package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PrescricaoDTO {
    Integer quantidadeUso;
    Integer quantidadeDiaria;
    String medicamento;
}
