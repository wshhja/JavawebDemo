package DAO;

import VO.User;

import java.util.List;

public interface ImplUserDAO {
    public void doInsert(User user) throws Exception;
    public List<User> getAll() throws Exception;
    public User getByName(String name,String ps) throws Exception;
    public User getById(int id) throws Exception;
    public void doDelete(User user)throws Exception;
    public void doUpdate(User user) throws Exception;
    public String getPsByNamePh(String name,String tel)throws Exception;
}
