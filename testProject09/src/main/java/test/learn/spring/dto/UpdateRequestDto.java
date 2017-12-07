package test.learn.spring.dto;

import lombok.Value;

@Value
public class UpdateRequestDto {

  private String name;
  private Long age;
}