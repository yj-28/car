package servlet;

import biz.CarBiz;
import biz.impl.CarBizImpl;
import entity.Cars;
import entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "addCarServlet")
public class addCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("loginUser");
        if(user==null){
            response.sendRedirect("login.jsp");
            return;
        }
        String id = request.getParameter("ID");
        System.out.println(id);
        String brand = request.getParameter("BRANK");
        System.out.println(brand);
        String color = request.getParameter("COLOR");
        System.out.println(color);
        String seats = request.getParameter("SEATS");
        System.out.println(seats);
        String consum = request.getParameter("CONSUM");
        System.out.println(consum);
        String productdate = request.getParameter("PRODUCTDATE");
        System.out.println(productdate);
        String rentmoney = request.getParameter("RENTMONEY");
        System.out.println(rentmoney);
        UserInfo users= (UserInfo) user;
        System.out.println(users.getUserName());
        Cars cars=new Cars();
        cars.setId(Integer.parseInt(id));
        cars.setBrand(brand);
        cars.setColor(color);
        cars.setSeats(Integer.parseInt(seats));
        cars.setConsum(consum);
        cars.setProductdate(productdate);
        cars.setRentmoney(rentmoney);
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取String类型的时间
        String createdate = sdf.format(date);
        System.out.println(createdate);
        cars.setCreatedate(createdate);
        cars.setUsername(users.getUserName());

        CarBiz cb=new CarBizImpl();
        cb.addCar(cars);
        request.getRequestDispatcher("/search").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
