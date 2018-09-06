package Proxy;

import DataBaseConnection.DBConnection;
import Impl.ComentImplDAO;
import VO.Coment;

import java.util.List;

public class ComentDAOProxy {
    private DBConnection dbc;
    private ComentImplDAO dao;

    public ComentDAOProxy() throws Exception{
        dbc=new DBConnection();
        dao=new ComentImplDAO(dbc.getCon());
    }

    public List<Coment> getByBlogId(int id) throws Exception{
        List<Coment> list=null;
        try{
            list=dao.getByBlogId(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbc.close();
        }
        return list;
    }

    public void doInsert(Coment user)throws Exception{
        dao.doInsert(user);
        dbc.close();
    }

    public void doDelete(int id) throws Exception{
        try{
            dao.doDelete(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        dbc.close();
    }

    public List<Coment> getByUserId(int id) throws Exception{
        List<Coment> list=null;
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
}
