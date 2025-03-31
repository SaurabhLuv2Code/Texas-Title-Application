package texas_title_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errorInfo = new HashMap<>();
        ExceptionResponse response = new ExceptionResponse();
        response.setHttpCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        response.setMessage("Validation failed: " + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        response.setSuccess(false);
        errorInfo.put("status", response);
        errorInfo.put("data", null);
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> exception(Exception ex) {

        Map<String, Object> errorInfo = new HashMap<>();
        ExceptionResponse response = new ExceptionResponse();
        response.setHttpCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        errorInfo.put("status", response);
        errorInfo.put("data", null);
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
