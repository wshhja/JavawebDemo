package Impl;

import DAO.ImplBlogDAO;
import VO.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogImplDAO implements ImplBlogDAO {
    private Connection con;
    private PreparedStatement pstmt = null;

    public  BlogImplDAO(Connection conn){
        con=conn;
    }

    @Override
    public void doInsert(Blog user) throws Exception {
        String sql="INSERT INTO blogs (userid,date,content,title)VALUES(?,?,?,?)";
        pstmt=con.prepareStatement(sql);//实例化PreparedStatement对象
        pstmt.setInt(1,user.getUserid());
        pstmt.setDate(2,user.getBlogdate());
        pstmt.setString(3, user.getContent());
        pstmt.setString(4, user.getTitle());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public List<Blog> getByUserId(int id) throws Exception {
        String sql="SELECT * FROM Blogs where userid=?";
        List<Blog> all= new ArrayList<Blog>();
        this.pstmt=this.con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=this.pstmt.executeQuery();
        Blog user=new Blog();
        while(rs.next()){
            user.setBlogid(rs.getInt("blogid"));
            user.setUserid(rs.getInt("userid"));
            user.setBlogdate(rs.getDate("date"));
            user.setContent(rs.getString("content"));
            user.setTitle(rs.getString("title"));
            all.add(user);
        }
        this.pstmt.close();
        con.close();
        return all;
    }

    @Override
    public void doDelete(int blogid) throws Exception {
        String sql="delete from blogs where blogid=?";
        pstmt=con.prepareStatement(sql);//实例化PreparedStatement对象
        pstmt.setInt(1,blogid);
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public void doUpdate(Blog blog) throws Exception {
        String sql="UPDATE blogs SET title=?, content=?,date=? where blogid=?";
        pstmt=con.prepareStatement(sql);//实例化PreparedStatement对象
        pstmt.setString(1,blog.getTitle());
        pstmt.setString(2,blog.getContent());
        pstmt.setDate(3,blog.getBlogdate());
        pstmt.setInt(4,blog.getBlogid());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public Blog getByBlogId(int id) throws Exception {
        String sql="SELECT * FROM Blogs where blogid=?";
        this.pstmt=this.con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=this.pstmt.executeQuery();
        Blog user=new Blog();
        if(rs.next()){
            user.setBlogid(rs.getInt("blogid"));
            user.setUserid(rs.getInt("userid"));
            user.setBlogdate(rs.getDate("date"));
            user.setContent(rs.getString("content"));
            user.setTitle(rs.getString("title"));
        }
        this.pstmt.close();
        con.close();
        return user;
    }
    @Override
    public List<Blog> getBlogs() throws Exception {
        String sql="SELECT * FROM Blogs limit 100";
        List<Blog> all= new ArrayList<Blog>();
        this.pstmt=this.con.prepareStatement(sql);
        ResultSet rs=this.pstmt.executeQuery();
        Blog user=new Blog();
        while(rs.next()){
            user.setBlogid(rs.getInt("blogid"));
            user.setUserid(rs.getInt("userid"));
            user.setBlogdate(rs.getDate("date"));
            user.setContent(rs.getString("content"));
            user.setTitle(rs.getString("title"));
            all.add(user);
        }
        this.pstmt.close();
        con.close();
        return all;
    }
}
