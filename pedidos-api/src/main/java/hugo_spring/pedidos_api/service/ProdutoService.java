package hugo_spring.pedidos_api.service;

import hugo_spring.pedidos_api.model.Produto;
import hugo_spring.pedidos_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    public List<Produto> listasDeProduto() {

        return produtoRepository.findByAtivoTrue();
    }

    public Produto criarProduto(Produto produto) {

        if (produto.getPreco() <= 0) {
            throw new RuntimeException("Preço invalido");
        }
        if (produto.getNomeProduto() == null || produto.getNomeProduto().isEmpty()) {
            throw new RuntimeException("Nome obrigatório");
        }
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produto) {

        Produto produtoEncontrado = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (produto.getPreco() <= 0) {
            throw new RuntimeException("Preço inválido");
        }
        produtoEncontrado.setNomeProduto(produto.getNomeProduto());
        produtoEncontrado.setDescricao(produto.getDescricao());
        produtoEncontrado.setPreco(produto.getPreco());

        return produtoRepository.save(produtoEncontrado);
    }

    public Produto atulizarParcialmente(Long id, Produto produto) {
        Produto produtoEncontrado = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        if (produto.getNomeProduto() != null) {
            produtoEncontrado.setNomeProduto(produto.getNomeProduto());
        }
        if (produto.getDescricao() != null) {
            produtoEncontrado.setDescricao(produto.getDescricao());
        }
        if (produto.getPreco() != null) {
            if (produto.getPreco() <= 0) {
                throw new RuntimeException("Preço invalido");
            }
            produtoEncontrado.setPreco(produto.getPreco());
        }
        return produtoRepository.save(produtoEncontrado);
    }

    public boolean deletarProduto(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        if (!produto.getAtivo()) {
            throw new RuntimeException("Produto já foi deletado");
        }
        produto.setAtivo(false);
        produtoRepository.save(produto);
        return true;
    }
}
