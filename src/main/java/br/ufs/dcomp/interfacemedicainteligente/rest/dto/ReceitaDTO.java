package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Receita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ReceitaDTO {

    private String descricao;

    private Boolean segunda_via;

    public ReceitaDTO(Receita receita) {

        descricao = receita.getDescricao();
        
        segunda_via = receita.getSegundaVia();
    }
}
