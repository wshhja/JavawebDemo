package Impl;

import DAO.ImplComentDAO;
import VO.Coment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComentImplDAO implements ImplComentDAO {
    private Connection con;
    private PreparedStatement pstmt = null;

    public  ComentImplDAO(Connection conn){
        con=conn;
    }

    @Override
    public void doInsert(Coment coment) throws Exception {
        String sql="INSERT INTO coments (userid,blogid,coment,date)VALUES(?,?,?,?)";
        pstmt=con.prepareStatement(sql);//实例化PreparedStatement对象
        pstmt.setInt(1,coment.getUserid());
        pstmt.setInt(2,coment.getBlogid());
        pstmt.setString(3, coment.getComent());
        pstmt.setDate(4, coment.getComentdate());
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public List<Coment> getByBlogId(int id) throws Exception {
        String sql="SELECT * FROM coments where blogid=?";
        List<Coment> all= new ArrayList<Coment>();
        this.pstmt=this.con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=this.pstmt.executeQuery();
        Coment user=new Coment();
        while(rs.next()){

            user.setComentid(rs.getInt("comentid"));
            user.setBlogid(rs.getInt("blogid"));
            user.setUserid(rs.getInt("userid"));
            user.setComentdate(rs.getDate("date"));
            user.setComent(rs.getString("coment"));
            all.add(user);
        }
        this.pstmt.close();
        return all;
    }

    @Override
    public List<Coment> getByUserId(int id) throws Exception {
        String sql="SELECT * FROM coments where userid=?";
        List<Coment> all= new ArrayList<Coment>();
        this.pstmt=this.con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=this.pstmt.executeQuery();
        Coment user=new Coment();
        while(rs.next()){
            user.setComentid(rs.getInt("comentid"));
            user.setBlogid(rs.getInt("blogid"));
            user.setUserid(rs.getInt("userid"));
            user.setComentdate(rs.getDate("date"));
            user.setComent(rs.getString("coment"));
            all.add(user);
        }
        this.pstmt.close();
        return all;
    }

    @Override
    public void doDelete(int id) throws Exception {
        String sql="delete from coments where comentid=?";
        pstmt=con.prepareStatement(sql);//实例化PreparedStatement对象
        pstmt.setInt(1,id);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
