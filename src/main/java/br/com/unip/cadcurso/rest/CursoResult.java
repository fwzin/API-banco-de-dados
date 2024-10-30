package br.com.unip.cadcurso.rest;

import br.com.unip.cadcurso.model.entity.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoResult {

    private List<Curso> cursos;

    public CursoResult(List<Curso> cursos) {
        if (cursos == null) {
            this.cursos = new ArrayList<>();
        } else {
            this.cursos = cursos;
        }
    }

    public List<Curso> getCursos() {
        return cursos;
    }
}
