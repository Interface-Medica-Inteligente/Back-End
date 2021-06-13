package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedicoDTO {

    private String senha;

    private String crm;

    private String nome;

    private String email;

    private String cpf;

    private char sexo;
}
