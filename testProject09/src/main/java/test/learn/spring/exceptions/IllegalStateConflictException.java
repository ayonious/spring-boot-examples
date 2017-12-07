package test.learn.spring.exceptions;

public class IllegalStateConflictException extends RuntimeException {
  public IllegalStateConflictException(String message) {
    super(message);
  }
}
