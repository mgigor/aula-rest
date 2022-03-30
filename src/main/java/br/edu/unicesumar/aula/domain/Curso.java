package br.edu.unicesumar.aula.domain;


import java.time.LocalDate;
//import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //  substitui getter e setter
@AllArgsConstructor  // substitui o construtor com parâmetros com argumentos
@NoArgsConstructor  //  substitui o construtor vazio, parâmetro vazio
@Entity  //  representa uma estrutura de banco de dados
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private UUID idCurso;
    private Long idCurso;

    @Column(name="Nome_do_Curso") // somente para alterar o nome da coluna no banco
    private String nomeCurso;

    private String descricaoCurso;

    private Long cargaHoraria;

    private LocalDate dataInicio;

    private LocalDate dataFim;



    
}
