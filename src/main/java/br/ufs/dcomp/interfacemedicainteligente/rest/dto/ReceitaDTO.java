package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ReceitaDTO {
    String descricao;
    Boolean segunda_via;
    LocalDate data_emissao;
}
