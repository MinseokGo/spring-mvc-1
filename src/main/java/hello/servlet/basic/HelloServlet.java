package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//name : 서블릿 이름, urlPatterns : URL 매핑
//name 과 urlPatterns 는 중복 안됨
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //response : response 객체 정보로 HTTP 응답 생성
        //header
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //body
        response.getWriter()
                .write("hello " + username);
    }
}
