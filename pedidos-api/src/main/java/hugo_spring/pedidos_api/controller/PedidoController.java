package hugo_spring.pedidos_api.controller;

import hugo_spring.pedidos_api.model.Pedido;
import hugo_spring.pedidos_api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoService.listaDePedidos();

    }
    @PostMapping
    public ResponseEntity<Pedido> criarPedidos(@RequestBody Pedido pedido){
        pedidoService.criarPedidos(pedido);
        return ResponseEntity.ok().build();
    }
}
