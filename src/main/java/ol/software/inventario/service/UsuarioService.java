package ol.software.inventario.service;

import java.util.List;
import java.util.Optional;
import ol.software.inventario.entity.UsuarioEntity;
import ol.software.inventario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioEntity> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity obtenerUsuarioPorId(Long id) {
        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(id);
        return usuarioEntityOptional.orElse(null);
    }

    public UsuarioEntity crearUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioEntity actualizarUsuario(Long id, UsuarioEntity usuario) {
        if(usuarioRepository.existsById(id)){
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}