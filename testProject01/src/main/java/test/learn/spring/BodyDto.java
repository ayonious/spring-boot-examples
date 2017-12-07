package test.learn.spring;

import lombok.AllArgsConstructor;
import lombok.Builder;

@lombok.Value
@Builder
@AllArgsConstructor
public class BodyDto {
    Boolean isBody;
    String id1;
    Long someStupidId;
}