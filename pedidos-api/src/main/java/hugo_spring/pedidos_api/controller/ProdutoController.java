package hugo_spring.pedidos_api.controller;


import hugo_spring.pedidos_api.model.Produto;
import hugo_spring.pedidos_api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdutoController {

    @Autowired
    public ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarPordutos() {
        return produtoService.listasDeProduto();
    }

    @PostMapping
    public Produto RegistrandoPorduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto AtulizarTodoProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

    @PatchMapping("/{id}")
    public Produto atulizarParciamenteProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atulizarParcialmente(id, produto);
    }

    @DeleteMapping("{id}")
    public boolean deletarProduto(@PathVariable Long id) {
        boolean produtoDeletado = produtoService.deletarProduto(id);
        if (produtoDeletado) {
            return ResponseEntity.noContent().build().hasBody();
        } else {
            return ResponseEntity.notFound().build().hasBody();
        }
    }
}
