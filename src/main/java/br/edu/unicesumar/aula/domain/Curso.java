package br.edu.unicesumar.aula.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome não dever ser vazio")
    private String nome;

    private String descricao;

    @NotNull()
    @Min(value = 20)
    @Max(value = 100)
    private Long cargaHoraria;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "curso_id")
    private List<Aula> aulas = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ementa_id")
    private Ementa ementa;

    @ManyToMany
    @JoinTable(name = "curso_alunos", joinColumns = {
            @JoinColumn(name = "curso_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "aluno_id")
    })
    private List<Aluno> alunos = new ArrayList<>();

}
