package Impl;

import DAO.ImplUserDAO;
import VO.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserImplDAO implements ImplUserDAO {
    private Connection con;
    private PreparedStatement pstmt = null;

    public  UserImplDAO(Connection conn){
        con=conn;
    }
    @Override
    public void doInsert(User user) throws Exception {
        String sql="INSERT INTO users (name,sex,age,tel,ps)VALUES(?,?,?,?,?)";
        pstmt=con.prepareStatement(sql);//实例化PreparedStatement对象
        pstmt.setString(1,user.getName());
        pstmt.setString(2,user.getSex());
        pstmt.setInt(3, user.getAge());
        pstmt.setString(4,user.getTel());
        pstmt.setString(5,user.getPs());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public List<User> getAll() throws Exception {
        List<User> all= new ArrayList<User>();
        String sql="SELECT * FROM users;";
        this.pstmt=this.con.prepareStatement(sql);
        ResultSet rs=this.pstmt.executeQuery();
        User user=new User();
        while(rs.next()){
            user.setUserid(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setSex(rs.getString("sex"));
            user.setAge(rs.getInt("age"));
            user.setTel(rs.getString("tel"));
            user.setPs(rs.getString("ps"));
            all.add(user);
        }
        this.pstmt.close();
        con.close();
        return all;
    }

    @Override
    public User getByName(String name,String ps) throws Exception {
        String sql="SELECT * FROM users where name=? and ps=?";
        pstmt=con.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,ps);
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            User user=new User();
            user.setUserid(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setSex(rs.getString("sex"));
            user.setAge(rs.getInt("age"));
            user.setTel(rs.getString("tel"));
            user.setPs(rs.getString("ps"));
            this.pstmt.close();
            con.close();
            return user;
        }
        con.close();
        return null;
    }

    @Override
    public User getById(int id) throws Exception {
        String sql="SELECT * FROM users where id=?";
        pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            User user=new User();
            user.setUserid(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setSex(rs.getString("sex"));
            user.setAge(rs.getInt("age"));
            user.setTel(rs.getString("tel"));
            user.setPs(rs.getString("ps"));
            this.pstmt.close();
            return user;
        }
        con.close();
        return null;
    }

    @Override
    public void doDelete(User user) throws Exception {

    }

    @Override
    public void doUpdate(User user) throws Exception {
        String sql="UPDATE users SET name=?, age=?,sex=?,tel=?,ps=? where id=?";
        pstmt=con.prepareStatement(sql);//实例化PreparedStatement对象
        pstmt.setString(1,user.getName());
        pstmt.setInt(2,user.getAge());
        pstmt.setString(3,user.getSex());
        pstmt.setString(4,user.getTel());
        pstmt.setString(5,user.getPs());
        pstmt.setInt(6,user.getUserid());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }

    @Override
    public String getPsByNamePh(String name, String tel) throws Exception {
        String sql="SELECT * FROM users where name=? and tel=?";
        pstmt=con.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,tel);
        ResultSet rs=pstmt.executeQuery();
        if(rs.next())
        {
            con.close();
            pstmt.close();
            rs.close();
            return rs.getString("ps");
        }
        else
        {
            con.close();
            pstmt.close();
            rs.close();
            return null;
        }
    }
}
