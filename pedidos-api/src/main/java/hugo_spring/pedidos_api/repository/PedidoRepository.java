package hugo_spring.pedidos_api.repository;

import hugo_spring.pedidos_api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository <Pedido, Long >  {
}
