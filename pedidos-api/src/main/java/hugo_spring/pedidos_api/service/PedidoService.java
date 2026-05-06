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

    public List<Pedido> listaDePedidos() {
        return pedidoRepository.findAll();
    }

    public void criarPedidos(Pedido pedido) {

        if (pedido == null) {
            throw new RuntimeException("Pedido não pode ser nulo");
        }

        if (pedido.getItemPedidos() == null || pedido.getItemPedidos().isEmpty()) {
            throw new RuntimeException("Pedido precisa ter pelo menos um item");
        }

        Usuario usuario = usuarioRepository.findById(pedido.getUsuario().getId()).orElseThrow();

        Pedido novoPedido = new Pedido();
        novoPedido.setUsuario(usuario);
        novoPedido.setDataPedido(LocalDateTime.now());

        List<ItemPedido> itemPedidos = new ArrayList<>();
        double totalPedido = 0;

        for (ItemPedido itemPedidoRecebido : pedido.getItemPedidos()) {

            Produto produto = produtoRepository.findById(itemPedidoRecebido.getProduto().getId()).orElseThrow();

            if (itemPedidoRecebido.getQuantidade() <= 0) {
                throw new RuntimeException("Quantidade inválida");
            }

            ItemPedido novoItemPedido = new ItemPedido();
            novoItemPedido.setProduto(produto);
            novoItemPedido.setQuantidade(itemPedidoRecebido.getQuantidade());
            novoItemPedido.setPrecoMomento(produto.getPreco());
            novoItemPedido.setPedido(novoPedido);

            totalPedido += novoItemPedido.getPrecoMomento() * novoItemPedido.getQuantidade();

            itemPedidos.add(novoItemPedido);
        }

        novoPedido.setItemPedidos(itemPedidos);
        novoPedido.setTotal(totalPedido);

        pedidoRepository.save(novoPedido);
    }
}
