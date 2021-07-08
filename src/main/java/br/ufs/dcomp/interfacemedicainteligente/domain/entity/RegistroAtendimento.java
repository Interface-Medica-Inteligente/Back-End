package br.ufs.dcomp.interfacemedicainteligente.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="registro_atendimento")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RegistroAtendimento implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_registro_atendimento")
    private Long id;

    @Column(name="estado_tratamento")
    private String estadoTratamento;

    @Column(name="anamnese_progressao")
    private String anamneseProgressao;

    private Boolean anamnese;

    @ManyToOne
    @JoinColumn(name="id_cnes")
    private CNES cnes;

    @OneToOne
    @JoinColumn(name="id_atendimento")
    private Atendimento atendimento;

    @OneToMany(mappedBy="registroAtendimento")
    private List<RegistroCID10> registrosCID10;
}
