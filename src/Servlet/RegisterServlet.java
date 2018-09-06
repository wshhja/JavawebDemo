package Servlet;

import Factory.DAOFactory;
import VO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setTel(req.getParameter("tel"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        user.setPs(req.getParameter("ps"));
        user.setSex(req.getParameter("sex"));
        try {
            DAOFactory.getImplUserDAOInstance().doInsert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            resp.sendRedirect("index.jsp");
        }
//        for(int i=1;i<=1000;i++){
//            user.setName("胡"+i);
//            user.setTel("18361220986");
//            user.setAge(21);
//            user.setPs("123456");
//            user.setSex("男");
//        try {
//            DAOFactory.getImplUserDAOInstance().doInsert(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}