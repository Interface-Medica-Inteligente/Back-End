package br.ufs.dcomp.interfacemedicainteligente.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="prescricao")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Prescricao implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_prescricao")
    private Long id;

    @Column(name="quantidade_uso")
    private String quantidadeDeUso;

    @Column(name="quantidade_diaria")
    private Integer quantidadeDiaria;

    @OneToOne
    @JoinColumn(name="id_medicamento")
    private Medicamento medicamento;
    
    @ManyToOne
    @JoinColumn(name="id_receita")
    private Receita receita;
}
