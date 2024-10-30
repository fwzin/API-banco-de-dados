package br.com.unip.cadcurso.model.dao;

import br.com.unip.cadcurso.model.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {
    
    List<Curso> findByNome(String nome);
    
}
