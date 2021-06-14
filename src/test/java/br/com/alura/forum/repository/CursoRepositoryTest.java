package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
//aqui ele considera o ambieente de testes como ativo no momento
@ActiveProfiles("test")
//Spring nao substituir o banco de dados que estou configurando para um banco de memoria que eh o default do Spring Boot
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CursoRepositoryTest extends TestCase {

    @Autowired
    private CursoRepository repository;

    @Test
    public void deveriaCarregarUmCursoPeloNome() {
        String nomeCurso = "HTML 5";
        Curso curso =  repository.findByNome(nomeCurso);
        Assert.assertNotNull(curso);
        Assert.assertEquals(nomeCurso, curso.getNome());

    }

    @Test
    public void naoDeveriaCarregarUmCursoPeloNome() {
        String nomeCurso = "JPA";
        Curso curso =  repository.findByNome(nomeCurso);
        Assert.assertNull(curso);

    }

}