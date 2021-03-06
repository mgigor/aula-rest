package br.edu.unicesumar.aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicesumar.aula.domain.Curso;
import br.edu.unicesumar.aula.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable(name = "id") Long id) {
        return this.cursoRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Page<Curso> buscarTodosOsCursos(Pageable pageable) {
        return this.cursoRepository.findAll(pageable);
    }

    @PostMapping
    public Curso criarNovoCurso(@RequestBody Curso curso) {
        return this.cursoRepository.save(curso);
    }

    @DeleteMapping("/{id}")
    public void deletarCurso(@PathVariable(name = "id") Long id) {
        this.cursoRepository.deleteById(id);
    }
 
    @PutMapping("/{id}")
    public Curso alterarCurso(@PathVariable(name = "id") Long id, @RequestBody Curso curso) {
        Curso cursoBancoDeDados = this.cursoRepository.findById(id).orElse(null);

        cursoBancoDeDados.setCargaHoraria(curso.getCargaHoraria());
        cursoBancoDeDados.setDataFim(curso.getDataFim());
        cursoBancoDeDados.setDescricao(curso.getDescricao());
        cursoBancoDeDados.setNome(curso.getNome());
        cursoBancoDeDados.setDataInicio(curso.getDataInicio());

        cursoBancoDeDados.setProfessor(curso.getProfessor());

        cursoBancoDeDados.getAulas().clear();
        cursoBancoDeDados.getAulas().addAll(curso.getAulas());

        return this.cursoRepository.save(cursoBancoDeDados);
    }

}
