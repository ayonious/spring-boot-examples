package test.learn.spring.exceptions;

public class IllegalInputException extends RuntimeException {
  public IllegalInputException(String message) {
    super(message);
  }
}
