package br.ufs.dcomp.interfacemedicainteligente.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="consulta")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Consulta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_consulta")
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name="id_paciente")
    private Paciente paciente;
}
