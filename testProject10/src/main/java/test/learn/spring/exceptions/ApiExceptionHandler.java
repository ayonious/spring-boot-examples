package test.learn.spring.exceptions;


import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import test.learn.spring.dto.Error;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  private ResponseEntity<Error> response(String description, @NonNull HttpStatus httpStatus) {
    return new ResponseEntity(
        new Error(httpStatus.toString(), description, httpStatus.getReasonPhrase()),
        httpStatus
    );
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Error> handleError(HttpServletRequest req, Exception ex) {
    log.info("Request: " + req.getRequestURL() + " raised ", ex);
    return response(ex.getMessage(), INTERNAL_SERVER_ERROR);
  }


  @ExceptionHandler(IllegalInputException.class)
  public ResponseEntity<Error> handleIllegalInputException(IllegalInputException ex) {

    log.info("Database Related", ex);
    return response(ex.getMessage(), BAD_REQUEST);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Error> handleResourceNotFoundException(
      ResourceNotFoundException ex) {

    log.warn("ResourceNotFoundException", ex);
    return response(ex.getMessage(), NOT_FOUND);
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<Error> handleRestApiException(ValidationException ex) throws IOException {

    log.warn("ValidationException", String.format("message %s", ex.getMessage()));
    return response(ex.getMessage(), BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    return new ResponseEntity(
        new Error(status.toString(), status.getReasonPhrase(), ex.getMessage()), status
    );
  }

}
