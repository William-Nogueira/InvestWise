package senior.com.br.InvestWise.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleError404() {
        return ResponseEntity.notFound().build();
    }

}
