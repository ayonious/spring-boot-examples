package test.learn.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;


@Value
@AllArgsConstructor
@Builder
public class Error {

  private String code;
  private String message;
  private String details;

}
