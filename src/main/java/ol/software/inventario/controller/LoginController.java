package ol.software.inventario.controller;

import ol.software.inventario.entity.LoginEntity;
import ol.software.inventario.entity.UsuarioEntity;
import ol.software.inventario.service.UsuarioService;
import ol.software.inventario.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private UsuarioService usuarioService;

  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginEntity login) {
    UsuarioEntity usuarioEncontrado = usuarioService.obtenerUsuarioPorUsuarioAndPassword(login.getUsuario(), login.getPassword());

    if (usuarioEncontrado != null) {
      String token = jwtUtil.generarToken(usuarioEncontrado.getId(), usuarioEncontrado.getUsuario());

      Map<String, String> respuesta = new HashMap<>();
      respuesta.put("token", token);

      return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

}