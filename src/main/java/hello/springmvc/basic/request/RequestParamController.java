package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class RequestParamController {

    @GetMapping("/request-param-v1")
    public void requestParamGetV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log(username, age);

        response.getWriter()
                .write("ok");
    }

    @PostMapping("/request-param-v1")
    public void requestParamPostV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log(username, age);

        response.getWriter()
                .write("ok");
    }

    private void log(String username, int age) {
        log.info("username={}, age={}", username, age);
    }
}
