package servlet;



import biz.CarBiz;
import biz.impl.CarBizImpl;
import entity.Cars;
import entity.PageBusiness;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarSearchServlet extends HttpServlet {
    public CarSearchServlet() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBusiness pb = new PageBusiness(1, 4, 0);
        if (request.getParameter("pageIndex") != null) {
            pb.setPageIndex(Integer.parseInt(request.getParameter("pageIndex")));
        }

        String brand = request.getParameter("brand");
        double lowseats = 0.0D;
        double highseats = 0.0D;
        System.out.println("brand:" + brand);
        System.out.println("lowseats:" + request.getParameter("lowseats"));
        if (request.getParameter("lowseats") != null && !request.getParameter("lowseats").equals("")) {
            lowseats = Double.parseDouble(request.getParameter("lowseats"));
        }

        if (request.getParameter("highseats") != null && !request.getParameter("highseats").equals("")) {
            highseats = Double.parseDouble(request.getParameter("highseats"));
        }

        CarBiz bb = new CarBizImpl();
        List<Cars> cars = bb.listByPage(brand, lowseats, highseats, pb);
        request.setAttribute("cars", cars);
        request.setAttribute("pb", pb);
        request.setAttribute("brand", brand);
        request.setAttribute("lowseats", lowseats);
        request.setAttribute("highseats", highseats);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBusiness pb = new PageBusiness(1, 4, 0);
        if (request.getParameter("pageIndex") != null) {
            pb.setPageIndex(Integer.parseInt(request.getParameter("pageIndex")));
        }

        String brand = request.getParameter("brand");
        if (brand != null && !brand.equals("")) {
            brand = new String(brand.getBytes("utf-8"), "utf-8");
        }

        double lowseats = 0.0D;
        double highseats = 0.0D;
        System.out.println("brand:" + brand);
        System.out.println("lowseats:" + request.getParameter("lowseats"));
        if (request.getParameter("lowseats") != null && !request.getParameter("lowseats").equals("")) {
            lowseats = Double.parseDouble(request.getParameter("lowseats"));
        }

        if (request.getParameter("highseats") != null && !request.getParameter("highseats").equals("")) {
            highseats = Double.parseDouble(request.getParameter("highseats"));
        }

        CarBiz bb = new CarBizImpl();
        List<Cars> cars = bb.listByPage(brand, lowseats, highseats, pb);
        request.setAttribute("cars", cars);
        request.setAttribute("pb", pb);
        request.setAttribute("brand", brand);
        request.setAttribute("lowseats", lowseats);
        request.setAttribute("highseats", highseats);
        request.getRequestDispatcher("main.jsp").forward(request, response);
        System.out.println(pb.getPageCount());
    }
}