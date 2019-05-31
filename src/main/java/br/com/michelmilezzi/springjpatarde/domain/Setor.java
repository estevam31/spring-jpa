package br.com.michelmilezzi.springjpatarde.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Setor {
//    id integer NOT NULL DEFAULT nextval('setor_id_seq'::regclass),
//    nome text NOT NULL,
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setor_gen")
    @SequenceGenerator(name = "setor_gen", sequenceName = "setor_id_seq", allocationSize = -1)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "setor")
    private List<Colaborador> colaboradores;

    @Override
    public String toString() {
        return String.format("[id = %d, nome = %s]", id, nome);
    }
}
