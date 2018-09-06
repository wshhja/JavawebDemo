package Servlet;

import Factory.DAOFactory;
import VO.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");

        if("out".equals(action)){
            req.getSession(false).invalidate();
            resp.sendRedirect("index.jsp");
        }
        else if("in".equals(action)){
            String name=req.getParameter("name");
            String ps=req.getParameter("ps");
            try{
                User user=DAOFactory.getImplUserDAOInstance().getByName(name,ps);
                if(user==null){
                    req.setAttribute("info","账户密码错误！请核查");
                    req.getRequestDispatcher("index.jsp").forward(req,resp);
                }
                else{
                    req.getSession().setAttribute("user",user);
                    resp.sendRedirect("./personInfo?action=login");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
