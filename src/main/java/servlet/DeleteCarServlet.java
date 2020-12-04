package servlet;

import biz.CarBiz;
import biz.impl.CarBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "DeleteCarServlet")
public class DeleteCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("sss");
        int id = Integer.parseInt(request.getParameter("id"));
        CarBiz cb=new CarBizImpl();
        boolean b=cb.deleteCar(id);
//        if(b){
//            request.getRequestDispatcher("/search").forward(request, response);
//        }

        Writer writer = response.getWriter();
        if (b){
            writer.write("删除成功");
        }else{
            writer.write("删除失败");
        }
        writer.flush();
        writer.close();
        //response.getWriter().println(b);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
