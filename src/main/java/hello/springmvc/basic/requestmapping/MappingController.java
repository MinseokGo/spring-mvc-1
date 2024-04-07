package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MappingController {

    @GetMapping("/hello-basic")
    public String helloBasic() {
        log.info("hello basic request");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mapping(@PathVariable String userId) {
        log.info("info log={}", userId);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mapping path userId={}, orderId={}", userId, orderId);
        return "ok";
    }
}
