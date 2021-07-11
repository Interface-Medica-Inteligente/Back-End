package br.ufs.dcomp.interfacemedicainteligente.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="atendimento")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Atendimento implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_atendimento")
    private Long id;

    @Column(name="data_atendimento")
    private LocalDate dataAtendimento;

    @Column(name="peso", precision=20, scale=2)
    private Double peso;

    @Column(name="altura", precision=20, scale=2)
    private Double altura;

    @OneToOne
    @JoinColumn(name="id_consulta")
    private Consulta consulta;

}
