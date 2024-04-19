package ol.software.inventario.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
  private List<ValidationError> errors;
}
