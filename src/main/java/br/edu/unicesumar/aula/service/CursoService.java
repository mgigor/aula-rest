package br.edu.unicesumar.aula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unicesumar.aula.domain.Curso;
import br.edu.unicesumar.aula.repository.CursoRepository;

@Service  // pra q serve?
public class CursoService {

    @Autowired  // pra q serve?
    private CursoRepository cursoRepository;

    public Curso save(Curso curso){
        return cursoRepository.save(curso);
    }

    

    
}
