package Main;
import java.sql.*;


public class oracleDBMS
{

    private String username;
    private String password;
    private final String CONN_STRING = "jdbc:oracle:thin:@//DESKTOP-VGRAGF8:1521/ORCL1";
    public Connection connection = null;
    //private static OracleDBMS instance = null;

    public oracleDBMS()
    {
        this.username = "sunny";
        this.password = "password";
    }

    public oracleDBMS(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

//    public static OracleDBMS getInstance()
//    {
//        if (instance == null)
//        {
//            instance = new OracleDBMS();
//        }
//        return instance;
//    }

    public Connection getConnection()
    {
        if (connection == null)
        {
            try
            {
                connection = DriverManager.getConnection(CONN_STRING, username, password);
               // System.out.println("Connection Successful!");

            } catch (SQLException e)
            {
                System.out.println("Connection Failed! Check it from console");
                e.printStackTrace();
            }
        }

        return connection;
    }


    public void closeConnection()
    {
        try
        {
            if (connection != null)
            {
                connection.close();
                connection = null;
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

}