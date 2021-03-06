package br.ufs.dcomp.interfacemedicainteligente.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cnes")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CNES implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_cnes")
    private Long id;

    private int codigo;

    @Column(name="nome_estabelecimento")
    private String nomeEstabelecimento;

}
