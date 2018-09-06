package Proxy;

import DataBaseConnection.DBConnection;
import Impl.UserImplDAO;
import VO.User;

import java.util.List;

public class UserDAOProxy {
    private DBConnection dbc;
    private UserImplDAO dao;

    public UserDAOProxy() throws Exception{

    }

    public List<User> getAll() throws Exception{
        dbc=new DBConnection();
        dao=new UserImplDAO(dbc.getCon());
        List<User> list=null;
        try{
            list=dao.getAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbc.close();
        }
        return list;
    }

    public User getByName(String name,String ps) throws Exception{
        dbc=new DBConnection();
        dao=new UserImplDAO(dbc.getCon());
        User user=null;
        try{
            user=dao.getByName(name,ps);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbc.close();
        }
        return user;
    }

    public User getById(int id) throws Exception{
        dbc=new DBConnection();
        dao=new UserImplDAO(dbc.getCon());
        User user=null;
        try{
            user=dao.getById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbc.close();
        }
        return user;
    }

    public void doInsert(User user)throws Exception{
        dbc=new DBConnection();
        dao=new UserImplDAO(dbc.getCon());
        dao.doInsert(user);
        dbc.close();
    }

    public void doUpdate(User user)throws Exception{
        dbc=new DBConnection();
        dao=new UserImplDAO(dbc.getCon());
        dao.doUpdate(user);
        dbc.close();
    }

    public String getPsByNameTel(String name,String tel)throws Exception{
        dbc=new DBConnection();
        dao=new UserImplDAO(dbc.getCon());
        String ps= dao.getPsByNamePh(name,tel);
        dbc.close();
        return ps;
    }
}
