package DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection con;

    public DBConnection()throws SQLException,
            InstantiationException, IllegalAccessException,
            ClassNotFoundException{
        // 加载数据库驱动类
        /**
         * 这是SqlServer的情形；
         * Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver"
         * ).newInstance();
         */
        Class.forName("com.mysql.jdbc.Driver");
        // 数据库连接URL
        /**
         * 这是SqlServer的情形；
         *
         * String url =
         * "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=Northwind";
         */
        String url = "jdbc:mysql://localhost:3306/test?user=root&&password=123&&serverTimezone=GMT";
        // 根据数据库参数取得一个数据库连接
        con = DriverManager.getConnection(url);
    }
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    /**
     * 取得一个数据库连接
     *
     * @return
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public void open() throws SQLException,
            InstantiationException, IllegalAccessException,
            ClassNotFoundException {

    }
    public void close()throws Exception{
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            throw new Exception("connection close exception: " + e.getMessage());
        }
    }
}
