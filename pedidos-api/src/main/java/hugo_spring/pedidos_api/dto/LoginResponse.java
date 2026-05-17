package hugo_spring.pedidos_api.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String nome;
    private String email;

}
