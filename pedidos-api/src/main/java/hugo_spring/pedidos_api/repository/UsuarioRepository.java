package hugo_spring.pedidos_api.repository;

import hugo_spring.pedidos_api.model.Produto;
import hugo_spring.pedidos_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Long> {
    boolean existsByEmail(String email);

    Usuario findByEmail(String email);

    List<Usuario> findByAtivoTrue();

}


