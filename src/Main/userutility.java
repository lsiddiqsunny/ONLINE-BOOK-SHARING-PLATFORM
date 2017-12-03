package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class userutility {

    public  static String  getusername(String Customer_id)
    {
        String sql = "SELECT Customer_name FROM Customer Where Customer_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "";
    }
    public static String getuserLocationid(String Customer_id)
    {
        String sql = "SELECT location_id FROM Customer Where Customer_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "";
    }

    public static String getuserLocation(String Location_id)
    {
        String sql = "SELECT * FROM LOCATION WHERE LOCATION_ID="+Location_id;

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                return rs.getString("Street_Address")+","+rs.getString("Post_code")+","+rs.getString("City")+",";


            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return "";
    }
    public static String getuserBranchid(String Customer_id)
    {
        String sql = "SELECT branch_id FROM Customer Where Customer_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "";
    }

    public static String getuserbranch(String Branch_id)
    {
        String sql = "SELECT * FROM BRANCH WHERE BRANCH_ID="+Branch_id;

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next())
            {

                return rs.getString("Branch_name")+".";


            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return "";
    }
    public static String getuserBEmail(String Customer_id)
    {
        String sql = "SELECT email FROM Customer Where Customer_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "";
    }
    public static String getuserPhone(String Customer_id)
    {
        String sql = "SELECT phone_number FROM Customer Where Customer_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString(1);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "";
    }
}
