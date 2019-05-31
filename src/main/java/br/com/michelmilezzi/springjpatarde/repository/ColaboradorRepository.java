package br.com.michelmilezzi.springjpatarde.repository;

import br.com.michelmilezzi.springjpatarde.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    @Query("SELECT c FROM Colaborador c LEFT JOIN c.setor s WHERE s IS NULL")
    List<Colaborador> colaboradoresSemSetor();


//    SELECT * FROM colaborador ORDER BY data_admissao ASC LIMIT 1
    @Query("SELECT min(c.dataAdmissao) FROM Colaborador c")
    LocalDate dataMaisAntiga();


//    SELECT * FROM colaborador WHERE nome ILIKE 'c%'
    List<Colaborador> findByNomeStartingWithIgnoreCase(String nome);


//    SELECT * FROM colaborador WHERE gerente_id IS NULL
    @Query("SELECT c FROM Colaborador c LEFT JOIN c.gerente g WHERE g IS NULL")
    List<Colaborador> colaboradoresSemGerente();

//    select c.nome, a.descricao from advertencia a JOIN colaborador c ON (a.colaborador_id = c.id) order by data_advertencia desc;
    @Query("SELECT c FROM Colaborador c JOIN FETCH c.advertencias a ORDER BY a.dataAdvertencia ASC")
    List<Colaborador> colaboradorEAdvertencia();


//    select * from colaborador where hora_inicial < '08:00:00';
    @Query("SELECT c FROM Colaborador c WHERE c.horaInicial < '08:00:00'")
    List<Colaborador> colaboresQueIniciamAntesDas8();

    @Query("SELECT avg(c.salario) FROM Colaborador c")
    BigDecimal mediaSalarialColaboradores();
}
