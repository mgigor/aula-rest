package br.edu.unicesumar.aula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import br.edu.unicesumar.aula.domain.Pedido;


public class PedidoService {
    
    @Autowired
    private PedidoService pedidoService;

    public Pedido save(Pedido pedido){
        return pedidoService.save(pedido);
    }

    public Page<Pedido> findAll(Pageable pageable){
        return pedidoService.findAll(pageable);
    }

    public Pedido findById(UUID id){
        return pedidoService.findById(id);
    }
}
