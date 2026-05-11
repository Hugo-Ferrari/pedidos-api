package hugo_spring.pedidos_api.controller;

import hugo_spring.pedidos_api.model.Usuario;
import hugo_spring.pedidos_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listaDeUsuario();
    }

    @DeleteMapping("/{id}")
    public boolean deletarUsuario(@PathVariable Long id){
        boolean usuarioDeletado = usuarioService.deletarUsuario(id);
        if(usuarioDeletado){
            return ResponseEntity.noContent().build().hasBody();
        } else {
            return ResponseEntity.notFound().build().hasBody();
        }
    }

    @PostMapping("/auth/register")
    public Usuario RegistrarUsuario(@RequestBody Usuario usuario ){
        return usuarioService.registrarUsuario(usuario);

    }

    @PostMapping("/auth/login")
    public String EntrarComUsuario(@RequestBody Usuario usuario){
        return usuarioService.LoginUsuario(usuario);
    }


}
