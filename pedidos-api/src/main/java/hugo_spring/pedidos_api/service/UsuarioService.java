package hugo_spring.pedidos_api.service;

import hugo_spring.pedidos_api.model.Usuario;
import hugo_spring.pedidos_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listaDeUsuario() {
        return usuarioRepository.findByAtivoTrue();
    }

    public boolean deletarUsuario(Long id) {
        Usuario user =  usuarioRepository.findById(id).orElseThrow();
        if (!user.getAtivo()) {
            throw new RuntimeException("Usuario já foi deletado");
        }
        user.setAtivo(false);
        usuarioRepository.save(user);
        return true;
    }

    public Usuario registrarUsuario(Usuario usuario) {

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario LoginUsuario(Usuario usuario){
        Usuario usuarioEncontrado =  usuarioRepository.findByEmail(usuario.getEmail());
        if(usuarioEncontrado == null){
            throw new RuntimeException("Email inexistente");
        }
        if(!usuarioEncontrado.getSenha().equals(usuario.getSenha())){
            throw new RuntimeException("Senha incorreta");
        }
        return usuarioEncontrado;
    }
}
