package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medicamento;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MedicamentoDTO {
    
    private String nome;

    @JsonCreator
    public MedicamentoDTO(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public MedicamentoDTO(Medicamento medicamento) {
        nome = medicamento.getNome();
    }
}
