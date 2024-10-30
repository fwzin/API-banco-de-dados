package br.com.unip.cadcurso.rest;

import br.com.unip.cadcurso.model.entity.Curso;
import br.com.unip.cadcurso.model.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/cursos")
public class CursoRestApi {

    @Autowired
    private CursoService cursoService;

    @GetMapping(produces = "application/json")
    public List<Curso> getEmployees() {
        List<Curso> cursos = new CursoResult(cursoService.findAll()).getCursos();
        System.out.println("chamada para endpoint /cursos size:"+cursos.size());
       return cursos;
    }


}
