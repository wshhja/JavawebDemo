package Servlet;

import Factory.DAOFactory;
import VO.Blog;
import VO.Coment;
import VO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        HttpSession session=req.getSession(false);
        if("info".equals(action)){
            try {
                int id=Integer.parseInt(req.getParameter("blogid"));
                Blog blog=DAOFactory.getImplBlogDAOInstance().getByBlogId(id);
                req.getSession().setAttribute("blog_info",blog);
                List<Coment> coments=null;//博客评论
                try {
                    coments=DAOFactory.getImplComentDAOInstance().getByBlogId(blog.getBlogid());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                req.getSession().setAttribute("coments",coments);
                resp.sendRedirect("blogInfo.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if("submit".equals(action)){
            String title=req.getParameter("title");
            String content=req.getParameter("content");
            Blog blog=new Blog();
            blog.setUserid(((User)session.getAttribute("user")).getUserid());
            blog.setTitle(title);
            blog.setContent(content);
            blog.setBlogdate(new Date(System.currentTimeMillis()));
            try {
                DAOFactory.getImplBlogDAOInstance().doInsert(blog);
                resp.sendRedirect("personInfo?action=login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if("delete".equals(action)){
            int id=Integer.parseInt(req.getParameter("blogid"));
            try {
                DAOFactory.getImplBlogDAOInstance().doDelete(id);
                resp.sendRedirect("./personInfo?action=login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if("update".equals(action)){
            int id=Integer.parseInt(req.getParameter("blogid"));
            try {
                Blog blog=DAOFactory.getImplBlogDAOInstance().getByBlogId(id);
                session.setAttribute("blog_update",blog);
                resp.sendRedirect("update_blog.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if("update_submit".equals(action)){
            Blog blog=(Blog)session.getAttribute("blog_update");
            session.removeAttribute("blog_update");
            blog.setBlogdate(new Date(System.currentTimeMillis()));
            blog.setTitle(req.getParameter("title"));
            blog.setContent(req.getParameter("content"));
            try {
                DAOFactory.getImplBlogDAOInstance().doUpdate(blog);
                resp.sendRedirect("personInfo?action=login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("url: "+req.getRequestURI());
            System.out.println(action+"  url error");
        }
    }
}
