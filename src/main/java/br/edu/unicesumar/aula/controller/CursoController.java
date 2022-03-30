package br.edu.unicesumar.aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicesumar.aula.domain.Curso;
import br.edu.unicesumar.aula.repository.CursoRepository;

@RestController  //  definir classe de controller que vai receber as classes http - springboot saber os endpoints que vai receber
@RequestMapping("/curso")  //  mapear e defenir acesso
public class CursoController {
    
    @Autowired
    private CursoRepository cursoRepository;


    @GetMapping
    public Page<Curso> buscarTodosOsCursosPage(Pageable pageable){
        return this.cursoRepository.findAll(pageable);
    }

    @PostMapping
    public Curso criarNovoCurso(@RequestBody Curso curso){
        return this.cursoRepository.save(curso);
    }

}
