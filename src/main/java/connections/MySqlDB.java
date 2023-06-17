package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDB
{

    private String userName;
    private String userPassword;
    private String dataBase;
    private String hostName;
    private String connectionStrng;
    private Connection conn;

    public MySqlDB()
    {
        this.userName = "root";
        this.userPassword = "";
        this.connectionStrng = "jdbc:mysql://127.0.0.1:3306/scraping?characterEncoding=UTF-8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    }

    public Connection openConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection(
                this.connectionStrng, userName, userPassword);

        return this.conn;
    }

    public void closeConnection() throws SQLException
    {
        this.conn.close();
    }

}
