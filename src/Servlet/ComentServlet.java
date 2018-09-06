package Servlet;

import Factory.DAOFactory;
import VO.Blog;
import VO.Coment;
import VO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class ComentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if("new".equals(action)){
            try {
                Coment coment=new Coment();
                String content=req.getParameter("newComent");
                coment.setComent(content);
                coment.setComentdate(new Date(System.currentTimeMillis()));
                coment.setBlogid(((Blog)req.getSession().getAttribute("blog_info")).getBlogid());
                coment.setUserid(((User)req.getSession().getAttribute("user")).getUserid());
                DAOFactory.getImplComentDAOInstance().doInsert(coment);
                req.getRequestDispatcher("./blog?action=info&blogid="+((Blog)req.getSession().getAttribute("blog_info")).getBlogid()).forward(req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if("delete".equals(action)){
            int id=Integer.parseInt(req.getParameter("comentid"));
            try {
                DAOFactory.getImplComentDAOInstance().doDelete(id);
                req.getRequestDispatcher("./blog?action=info&blogid="+((Blog)req.getSession().getAttribute("blog_info")).getBlogid()).forward(req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
