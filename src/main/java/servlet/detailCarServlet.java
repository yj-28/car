package servlet;

import biz.CarBiz;
import biz.impl.CarBizImpl;
import entity.Cars;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "detailCarServlet")
public class detailCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarBiz cb=new CarBizImpl();
        Cars car=new Cars();
        int id = Integer.parseInt(request.getParameter("id"));
        car=cb.searchById(id);
        request.setAttribute("Car",car);
        request.getRequestDispatcher("/search").forward(request, response);
        //request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
