package br.edu.unicesumar.aula.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String Data;

    private Double total;
    
}
