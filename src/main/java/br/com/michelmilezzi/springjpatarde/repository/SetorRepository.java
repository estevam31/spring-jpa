package br.com.michelmilezzi.springjpatarde.repository;

import br.com.michelmilezzi.springjpatarde.domain.MediaSalarial;
import br.com.michelmilezzi.springjpatarde.domain.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

    @Query("SELECT s FROM Setor s LEFT JOIN s.colaboradores c WHERE c IS NULL")
    List<Setor> setoresSemColaboradores();
}
