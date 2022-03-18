package br.edu.unicesumar.aula.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


import br.edu.unicesumar.aula.domain.Curso;

public interface CursoRepository extends JpaRepository <Curso, Long> {

    Page<Curso> findByNomeIgnoreCaseContaining(String nomeCurso, Pageable pageable);
    
    


    
}
