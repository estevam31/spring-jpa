package br.com.michelmilezzi.springjpatarde.domain;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class Colaborador {
//    id integer NOT NULL DEFAULT nextval('colaborador_id_seq'::regclass),
//    nome text NOT NULL,
//    setor_id integer,
//    gerente_id integer,
//    hora_inicial time without time zone NOT NULL,
//    hora_final time without time zone NOT NULL,
//    data_admissao date,
//    salario numeric(16,4) NOT NULL DEFAULT 0,
//    bonus numeric(16,4) NOT NULL DEFAULT 0,

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "colaborador_gen")
    @SequenceGenerator(name="colaborador_gen", sequenceName = "colaborador_id_seq", allocationSize = -1)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "setor_id", referencedColumnName = "id")
    private Setor setor;

    @ManyToOne
    @JoinColumn(name = "gerente_id", referencedColumnName = "id")
    private Colaborador gerente;

    @Column(name = "hora_inicial")
    private LocalTime horaInicial;

    @Column(name = "hora_final")
    private LocalTime horaFinal;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    @OneToMany(mappedBy = "colaborador")
    private List<Advertencia> advertencias;

    private BigDecimal salario;

    private BigDecimal bonus;
}
