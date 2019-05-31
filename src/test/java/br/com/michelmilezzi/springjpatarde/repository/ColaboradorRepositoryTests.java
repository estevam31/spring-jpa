package br.com.michelmilezzi.springjpatarde.repository;

import br.com.michelmilezzi.springjpatarde.domain.Advertencia;
import br.com.michelmilezzi.springjpatarde.domain.Colaborador;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ColaboradorRepositoryTests {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Test
    @Transactional
    public void findAllTests() {
        List<Colaborador> colaboradores = colaboradorRepository.findAll();
        for (Colaborador c : colaboradores) {
            System.out.println(c);
        }

        assertThat(colaboradores.size()).isEqualTo(11);
    }

    @Test
    @Transactional
    public void colaboradoresSemSetorTests() {
        List<Colaborador> colaboradores = colaboradorRepository.colaboradoresSemSetor();

        for (Colaborador c : colaboradores) {
            System.out.println(c);
        }

        assertThat(colaboradores.size()).isEqualTo(1);
    }

    @Test
    @Transactional
    public void dataMaisAntigaTests() {
        LocalDate dataMaisAntiga = colaboradorRepository.dataMaisAntiga();
        System.out.println(dataMaisAntiga);

        assertThat(dataMaisAntiga).isEqualTo("1999-01-01");
    }

    @Test
    @Transactional
    public void nomeComecaPorCTests() {
        List<Colaborador> colaboradores = colaboradorRepository.findByNomeStartingWithIgnoreCase("c");

        for (Colaborador c : colaboradores) {
            System.out.println(c);
        }

        assertThat(colaboradores.size()).isEqualTo(2);
    }

    @Test
    @Transactional
    public void colaboradorSemGerenteTests() {
        List<Colaborador> colaboradores = colaboradorRepository.colaboradoresSemGerente();

        for (Colaborador c : colaboradores) {
            System.out.println(c);
        }

        assertThat(colaboradores.size()).isEqualTo(4);
    }

    @Test
    public void colaboradorEgerenteTests() {
        List<Colaborador> colaboradores = colaboradorRepository.findAll();

        for (Colaborador c : colaboradores) {
            System.out.println(
                    String.format("[Colaborador -> %s || Gerente -> %s]",
                            c.getNome(),
                            c.getGerente() == null ? "Não tem gerente." : c.getGerente().getNome()));
        }

        assertThat(colaboradores.size()).isEqualTo(11);
    }

    @Test
    public void colaboradorEAdvertenciasTests() {
        List<Colaborador> colaboradores = colaboradorRepository.colaboradorEAdvertencia();

        for (Colaborador c : colaboradores) {

            for (Advertencia advertencia : c.getAdvertencias()) {
                System.out.println(
                        String.format(
                                "Colaborador: %s || Advertencia: %s",
                                c.getNome(), advertencia.getDescricao()
                        ));
            }
        }
        assertThat(colaboradores.size()).isEqualTo(7);
    }

    @Test
    @Transactional
    public void colaboradorIniciaAntesDas8Tests(){
        List<Colaborador> colaboradores = colaboradorRepository.colaboresQueIniciamAntesDas8();

        for(Colaborador c : colaboradores){
            System.out.println(c);
        }

        assertThat(colaboradores.size()).isEqualTo(10);
    }

    @Test
    @Transactional
    public void mediaSalarialTests(){
        BigDecimal mediaSalarial = colaboradorRepository.mediaSalarialColaboradores();
        System.out.println(mediaSalarial);

        assertThat(mediaSalarial).isBetween(BigDecimal.valueOf(6439), BigDecimal.valueOf(6440));
    }
}
