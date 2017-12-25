package Forgetpassword;

import Main.oracleDBMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class admininfo {

    public  static  List<List<String>> admin()
    {String sql = "select employee_name,email,phone_number\n" +
            "from employee\n" +
            "where job_id=18";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("employee_name")+"\nEmail: "+rs.getString("email")+"\nPhone number: "+rs.getString("phone_number"));

                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return resultList;
    }
    public  static String  getEmail(String customer)
    {
        String sql = "select email from customer\n" +
                "where customer_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,customer);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString("email");
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    public  static String  getPhone(String customer)
    {
        String sql = "select phone_number from customer\n" +
                "where customer_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,customer);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString("phone_number");
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    public  static boolean updatePass(String pass,String customer)
    {
        String sql = "Update customer\n" +
                "set password=?\n" +
                "where CUSTOMER_ID=?";
        System.out.println(sql);
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,pass);
            pst.setString(2,customer);
            ResultSet rs =  pst.executeQuery();

            pst.close();
            con.close();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
}
