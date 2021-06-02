package br.com.alura.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);

	// A vantagem dessa segunda abordagem é que você coloca o nome do método que você quiser, em português, no estilo que você quiser, só que a desvantagem é que você vai ter que montar a Query manualmente. Você vai ter que colocar o @Query e
	// gerar a Query manualmente com JPQL.
//	@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
//	List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso)
}