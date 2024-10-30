package br.com.unip.cadcurso.controller;

import br.com.unip.cadcurso.model.entity.Curso;
import br.com.unip.cadcurso.model.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CursoController {

    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("cursos", cursoService.findAll());
        return "index";
    }
    
    @GetMapping("/signup")
    public String showSignUpForm(Curso curso) {
        return "add-curso";
    }
    
    @PostMapping("/addcurso")
    public String addCurso(@Valid Curso curso, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-curso";
        }
        curso.setValor(12.50);
        cursoService.save(curso);
        return "redirect:/index";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Curso curso = cursoService.findById(id).orElseThrow(() -> new IllegalArgumentException("Curso Inválido Id:" + id));
        model.addAttribute("curso", curso);
        
        return "update-curso";
    }
    
    @PostMapping("/update/{id}")
    public String updateCurso(@PathVariable("id") long id, @Valid Curso curso, BindingResult result, Model model) {
        if (result.hasErrors()) {
            curso.setId(id);
            return "update-curso";
        }
        
        cursoService.save(curso);

        return "redirect:/index";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteCurso(@PathVariable("id") long id, Model model) {
        Curso curso = cursoService.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Usuario invãlido Id:" + id));
        cursoService.delete(curso);
        
        return "redirect:/index";
    }
}
