package Servlet;

import Factory.DAOFactory;
import VO.Blog;
import VO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class personInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if("login".equals(action)){
            update(req,resp);
            resp.sendRedirect("home.jsp");
        }
        else if("update".equals(action)){
            User user = new User();
            int id=((User)req.getSession().getAttribute("user")).getUserid();
            user.setUserid(id);
            user.setName(req.getParameter("name"));
            user.setTel(req.getParameter("tel"));
            user.setAge(Integer.parseInt(req.getParameter("age")));
            user.setPs(req.getParameter("ps"));
            user.setSex(req.getParameter("sex"));
            try {
                DAOFactory.getImplUserDAOInstance().doUpdate(user);
                req.getSession().setAttribute("user",user);
                resp.sendRedirect("./personInfo?action=login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if("info".equals(action)){
            int id=Integer.parseInt(req.getParameter("userid"));
            try {
                User user_info=DAOFactory.getImplUserDAOInstance().getById(id);
                req.getSession().setAttribute("user_info",user_info);
                resp.sendRedirect("./userInfo.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if("findPs".equals(action)){
            //向前台的页面输出结果
            String name=req.getParameter("name");
            String tel=req.getParameter("tel");
            try {
                String ps=DAOFactory.getImplUserDAOInstance().getPsByNameTel(name,tel);
                PrintWriter out=resp.getWriter();
                if(ps!=null)
                    out.print("您的密码为："+ps+"，请注意保管");
                else
                    out.print("请检查姓名手机号是否正确");
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void update(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int id=((User)req.getSession().getAttribute("user")).getUserid();
        List<Blog> list=null;//我的博客
        try {
            list=DAOFactory.getImplBlogDAOInstance().getByUserId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("blogs",list);//将博客绑定到session里面

        //广场博客筛选数据库前100条
        try {
            List<Blog> blogs=DAOFactory.getImplBlogDAOInstance().getBlogs();
            req.getSession().setAttribute("blog_around",blogs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
