package Proxy;

import DataBaseConnection.DBConnection;
import Impl.BlogImplDAO;
import VO.Blog;

import java.util.List;

public class BlogDAOProxy {
    private DBConnection dbc;
    private BlogImplDAO dao;

    public BlogDAOProxy() throws Exception{
    }

    public List<Blog> getByUserId(int id) throws Exception{
        dbc=new DBConnection();
        dao=new BlogImplDAO(dbc.getCon());
        List<Blog> list=null;
        try{
            list=dao.getByUserId(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbc.close();
        }
        return list;
    }

    public void doInsert(Blog user)throws Exception{
        dbc=new DBConnection();
        dao=new BlogImplDAO(dbc.getCon());
        dao.doInsert(user);
        dbc.close();
    }

    public void doDelete(int id) throws Exception{
        dbc=new DBConnection();
        dao=new BlogImplDAO(dbc.getCon());
        try{
            dao.doDelete(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        dbc.close();
    }

    public void doUpdate(Blog blog) throws Exception{
        dbc=new DBConnection();
        dao=new BlogImplDAO(dbc.getCon());
        try{
            dao.doUpdate(blog);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        dbc.close();
    }
    public Blog getByBlogId(int id) throws Exception{
        dbc=new DBConnection();
        dao=new BlogImplDAO(dbc.getCon());
        try{
            return dao.getByBlogId(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        dbc.close();
        return null;
    }

    public List<Blog> getBlogs()throws Exception{
        dbc=new DBConnection();
        dao=new BlogImplDAO(dbc.getCon());
        try{
            return dao.getBlogs();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
