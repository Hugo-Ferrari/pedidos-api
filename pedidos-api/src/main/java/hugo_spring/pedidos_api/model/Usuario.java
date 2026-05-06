package hugo_spring.pedidos_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // gerando o getters, setters, equals e hascode automaticamente
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Boolean ativo = true;
}
