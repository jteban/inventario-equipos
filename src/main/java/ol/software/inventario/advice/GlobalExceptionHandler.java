package ol.software.inventario.advice;

import java.util.ArrayList;
import java.util.List;
import ol.software.inventario.model.ErrorResponse;
import ol.software.inventario.model.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
    List<ValidationError> errors = new ArrayList<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> {
      ValidationError validationError = new ValidationError();
      validationError.setField(error.getField());
      validationError.setMessage(error.getDefaultMessage());
      errors.add(validationError);
    });

    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setErrors(errors);

    return ResponseEntity.badRequest().body(errorResponse);
  }

}
