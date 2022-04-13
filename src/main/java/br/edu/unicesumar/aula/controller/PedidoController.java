package br.edu.unicesumar.aula.controller;

import java.security.Provider.Service;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicesumar.aula.domain.Pedido;
import br.edu.unicesumar.aula.repository.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public Pedido buscarPedidoId(@PathVariable(name="id") UUID id){
        return pedidoService.find(id);
    }  
}
