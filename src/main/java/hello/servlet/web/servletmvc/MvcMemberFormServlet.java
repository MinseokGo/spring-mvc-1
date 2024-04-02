package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// 1. 클라이언트에서 서버 호출
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";

        // view 로 이동
        // 2. 요청 처리 객체 얻음
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        // forward: 서버 내부에서 일어나는 호출
        // 3. 서버 내부에서 요청, 응답을 실어 JSP 호출
        requestDispatcher.forward(request, response);
    }
}
