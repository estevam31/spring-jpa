package br.com.michelmilezzi.springjpatarde.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter

@Entity
public class Advertencia {
//    id integer NOT NULL DEFAULT nextval('advertencia_id_seq'::regclass),
//    colaborador_id integer NOT NULL,
//    gerente_id integer,
//    descricao text NOT NULL,
//    data_advertencia date,
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "advertencia_gen")
    @SequenceGenerator(name = "advertencia_gen", sequenceName = "advertencia_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "colaborador_id", referencedColumnName = "id")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "gerente_id", referencedColumnName = "id")
    private Colaborador gerente;

    private String descricao;

    @Column(name = "data_advertencia")
    private LocalDate dataAdvertencia;

    @Override
    public String toString(){
        return String.format("Advertencia; %d | Descrição: %s", id, descricao);
    }
}
