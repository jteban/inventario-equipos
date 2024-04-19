package ol.software.inventario.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import ol.software.inventario.entity.UsuarioEntity;
import ol.software.inventario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private Validator validator;
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
        Set<ConstraintViolation<UsuarioEntity>> constraintViolations = validator.validate(usuario);

        if (!constraintViolations.isEmpty()) {
            // Manejar las violaciones de validación
            StringBuilder messageBuilder = new StringBuilder();
            for (ConstraintViolation<UsuarioEntity> violation : constraintViolations) {
                messageBuilder.append(violation.getMessage()).append("\n");
            }
            throw new IllegalArgumentException(messageBuilder.toString());
        }

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