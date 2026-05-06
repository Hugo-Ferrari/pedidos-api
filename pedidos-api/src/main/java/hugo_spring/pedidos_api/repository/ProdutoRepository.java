package hugo_spring.pedidos_api.repository;

import hugo_spring.pedidos_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {
    List<Produto> findByAtivoTrue();
}
