package cn.whitesoul.wslib.database.mysql;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class SQL {
    public static void createTable(String table, String columns) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + table + " (" + columns + ");" ;
            Mysql.getConn().createStatement().executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库建表出错");
        }
    }
    //通过UUID查询
    public static ResultSet uuidQuery(UUID uuid , String table) {
        try {
            String sql = "SELECT UUID FROM "+ table +" WHERE UUID = ?";
            PreparedStatement preparedStatement = Mysql.getConn().prepareStatement(sql);
            preparedStatement.setString(1, uuid.toString());
            return preparedStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("数据库查询出错");
            e.printStackTrace();
        }
        return null;
    }
    //通过UUID更新数据
    public static void updateUUID(UUID uuid, String table, String column, String value) {
        try {
            String sql = "UPDATE " + table + " SET " + column + " = ? WHERE UUID = ?" ;
            PreparedStatement preparedStatement = Mysql.getConn().prepareStatement(sql);
            preparedStatement.setString(1, value);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库更新出错");
        }
    }
    //简化插入数据语句
    public static PreparedStatement insertTableSQL(String table, String columns, String values) {
        String sql = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ");";
        try {
            return Mysql.getConn().prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库插入出错");
        }
        return null;
    }
    //数据库删除
    public static void deleteUUID(String table, String where) {
        try {
            String sql = "DELETE FROM " + table + " WHERE " + where;
            Mysql.getConn().prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库删除出错");
        }

    }
}
