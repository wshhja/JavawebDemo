package Factory;

import Proxy.BlogDAOProxy;
import Proxy.ComentDAOProxy;
import Proxy.UserDAOProxy;

public class DAOFactory {
    public static UserDAOProxy getImplUserDAOInstance()throws Exception{
        return new UserDAOProxy();
    }

    public static BlogDAOProxy getImplBlogDAOInstance()throws Exception{
        return new BlogDAOProxy();
    }

    public static ComentDAOProxy getImplComentDAOInstance()throws Exception{
        return new ComentDAOProxy();
    }
}
