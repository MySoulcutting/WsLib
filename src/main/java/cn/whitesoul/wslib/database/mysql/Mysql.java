package cn.whitesoul.wslib.database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mysql {
    private static Connection conn;

    public static void setConn(String URL, String database, String name, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + URL + "/" + database, name, password);
            System.out.println("数据库加载成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库加载出错");
        }
    }

    public static void setConn(Connection conn) {
        Mysql.conn = conn;
    }

    public static Connection getConn() {
        return conn;
    }
    public static void closeConn() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库关闭出错");
        }
    }

}
