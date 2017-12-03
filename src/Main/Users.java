package Main;

/*
 * Created by Latif Siddiq Suuny on 30-Nov-17.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Users
{
    private static Users instance;

//    private Users()
//    {
//    }

    //    public static Users getInstance()
//    {
//        if (instance == null)
//        {
//            instance = new Users();
//        }
//        return instance;
//    }
    public boolean validateLogin(String loginas,String userName, String password)
    {
        boolean success = false;
        String sql = "SELECT * FROM "+loginas+" WHERE "+loginas+"_ID = ? AND PASSWORD=?";
        //System.out.println(sql);


        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, userName);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                success = true;
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return success;
    }


}
