package br.ufs.dcomp.interfacemedicainteligente.rest.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class InformacaoReceitaDTO {
    
    private Long receita;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAtendimento;

    private List<MedicamentoDTO> medicamentos;
    
}
