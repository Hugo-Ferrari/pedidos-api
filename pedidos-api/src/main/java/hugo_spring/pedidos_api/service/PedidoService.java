package hugo_spring.pedidos_api.service;

import hugo_spring.pedidos_api.model.ItemPedido;
import hugo_spring.pedidos_api.model.Pedido;
import hugo_spring.pedidos_api.model.Produto;
import hugo_spring.pedidos_api.model.Usuario;
import hugo_spring.pedidos_api.repository.PedidoRepository;
import hugo_spring.pedidos_api.repository.ProdutoRepository;
import hugo_spring.pedidos_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Pedido> listaDePedidos(){
        return pedidoRepository.findAll();
    }

    public void criarPedidos(Pedido pedido){
        Usuario usuario = usuarioRepository.findById(pedido.getUsuario().getId()).orElseThrow();

        Pedido novoPedido= new Pedido();
        novoPedido.setUsuario(usuario);
        novoPedido.setDataPedido(LocalDateTime.now());


        List<ItemPedido> itemPedidos = new ArrayList<>();
        for(ItemPedido itemPedidoRecebido : pedido.getItemPedidos()){
            Produto produto = produtoRepository.findById(itemPedidoRecebido.getProduto().getId()).orElseThrow();
            ItemPedido novoItemPedido = new ItemPedido();
            novoItemPedido.setProduto(produto);
            novoItemPedido.setQuantidade(itemPedidoRecebido.getQuantidade());
            novoItemPedido.setPrecoMomento(produto.getPreco());
            novoItemPedido.setPedido(novoPedido);
            itemPedidos.add(novoItemPedido);
        }
        novoPedido.setItemPedidos(itemPedidos);
        pedidoRepository.save(novoPedido);
    }
}
