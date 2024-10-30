package br.com.unip.cadcurso.model.service;

import br.com.unip.cadcurso.model.dao.CursoRepository;
import br.com.unip.cadcurso.model.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;


    public List<Curso> findAll() {
        Iterable<Curso> all = repository.findAll();
        return (List<Curso>) all;
    }

    public void save(Curso curso) {
        repository.save(curso);
    }

    public Optional<Curso> findById(long id) {
        return repository.findById(id);
    }

    public void delete(Curso curso) {
        repository.delete(curso);
    }
}
