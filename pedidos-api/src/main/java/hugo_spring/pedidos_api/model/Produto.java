package hugo_spring.pedidos_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeProduto;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false , length = 500)
    private String descricao;

    @Column (nullable = false)
    private  Boolean ativo =true;



}
