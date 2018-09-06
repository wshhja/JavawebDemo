package DAO;

import VO.Coment;

import java.util.List;

public interface ImplComentDAO {
    public void doInsert(Coment coment) throws Exception;
    public List<Coment> getByBlogId(int id) throws Exception;
    public List<Coment> getByUserId(int id) throws Exception;
    public void doDelete(int id)throws Exception;
}
