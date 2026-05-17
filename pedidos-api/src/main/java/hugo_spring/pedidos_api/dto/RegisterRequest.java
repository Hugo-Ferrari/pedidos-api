package hugo_spring.pedidos_api.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String nome;
    private String email;
    private String senha;
    private String endereco;
}
