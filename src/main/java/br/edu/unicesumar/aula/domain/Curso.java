package br.edu.unicesumar.aula.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCurso;

    @Column(name="Nome_do_Curso") // somente para alterar o nome da coluna no banco
    private String nomeCurso;

    private String descricaoCurso;

    private int cargaHoraria;

    private LocalDate dataInicio;

    private LocalDate dataFim;



    
}
