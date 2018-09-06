package DAO;

import VO.Blog;
import VO.User;

import java.util.List;

public interface ImplBlogDAO {
    public void doInsert(Blog user) throws Exception;
    public List<Blog> getByUserId(int id) throws Exception;
    public void doDelete(int id)throws Exception;
    public void doUpdate(Blog blog)throws Exception;
    public Blog getByBlogId(int id) throws Exception;
    public List<Blog> getBlogs() throws Exception;
}
