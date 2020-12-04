package servlet;

import biz.UserInfoBiz;
import biz.impl.UserInfoBizImpl;
import entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        UserInfo user = new UserInfo();
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        UserInfoBiz uib = new UserInfoBizImpl();
        int flag = uib.login(user);
        if (flag == 1) {
            request.getSession().setAttribute("loginUser", user);

        }

        out.write(String.valueOf(flag));
        out.flush();
        out.close();
    }
}
