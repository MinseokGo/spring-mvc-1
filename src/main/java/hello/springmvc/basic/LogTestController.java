package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // TRACE > DEBUG > INFO > WARN > ERROR 레벨 순
        log.trace("trace log={}", name);    // 개발 서버용
        log.debug("debug log={}", name);    // 개발 서버용
        log.info(" info log={}", name);     // 운영 서버용
        log.warn(" warn log={}", name);
        log.error("error log={}", name);

        // 만약 로깅 레벨이 DEBUG 인데, TRACE 레벨의 로그를 아래의 형식으로 작성한다면?
        // 메서드 호출보다 파라미터로 전달되는 trace log= + name 연산이 먼저 일어나서
        // 로깅되지 않는 TRACE 레벨의 로그이지만, 문자열 연산이 일어나므로
        // 서버 자원을 불필요하게 소비함
        log.trace("trace log=" + name);

        return "ok";
    }
}
