package project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//sql server連工具類，提供數據庫連接方法
public class ConnectionUtil { // 設置為public
    //sql連接url，指定地址和加密配置
    private static String url = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=TouristStats;"
            + "encrypt=false";
    //帳號
    private static String user = "sa";
    //密碼
    private String pwd = "Dask8610@";
    //獲取sql連接方法
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pwd);
    }
}
