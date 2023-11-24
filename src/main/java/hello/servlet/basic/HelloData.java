package hello.servlet.basic;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HelloData {
    private String username;
    private int age;
}
