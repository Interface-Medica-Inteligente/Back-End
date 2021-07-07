package br.ufs.dcomp.interfacemedicainteligente.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="receita")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Receita implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_receita")
    private Long id;

    private String descricao;

    @Column(name="segunda_via")
    private Boolean segundaVia;

    @Column(name="data_emissao")
    private LocalDate dataEmissao;

    @OneToOne
    @JoinColumn(name="id_atendimento")
    private Atendimento atendimento;

    @OneToMany(mappedBy="receita", fetch=FetchType.LAZY)
    private List<Prescricao> prescricoes;
}
