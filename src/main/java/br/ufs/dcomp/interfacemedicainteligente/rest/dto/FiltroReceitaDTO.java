package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class FiltroReceitaDTO {
    
    private Long receita;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEmissao;

    private String medicamento;
}
