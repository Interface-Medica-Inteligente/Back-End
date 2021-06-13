package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;
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
    
    public MedicoDTO(Medico medico) {
    	senha = medico.getSenha();
    	crm = medico.getSenha();
    	nome = medico.getNome();
    	email = medico.getEmail();
    	cpf = medico.getCpf();
    	sexo = medico.getSexo();
    }
}
