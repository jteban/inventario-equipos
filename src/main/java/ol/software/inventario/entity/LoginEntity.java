package ol.software.inventario.entity;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginEntity {

  @NotEmpty(message = "Este campo es obligatorio")
  private String usuario;
  @NotEmpty(message = "Este campo es obligatorio")
  private String password;
}
