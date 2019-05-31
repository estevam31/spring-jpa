package br.com.michelmilezzi.springjpatarde.repository;


import br.com.michelmilezzi.springjpatarde.domain.Setor;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SetorRepositoryTests {

    @Autowired
    private SetorRepository setorRepository;

    @Test
    public void setorSemColaboradores(){
        List<Setor> setores = setorRepository.setoresSemColaboradores();

        for (Setor s: setores){
            System.out.println(s);
        }

        assertThat(setores.size()).isEqualTo(1);
    }
}
