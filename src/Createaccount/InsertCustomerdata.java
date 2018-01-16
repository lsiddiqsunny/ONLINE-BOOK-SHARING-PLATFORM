package Createaccount;

import Main.oracleDBMS;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

/**
 * Created by Latif Siddiq Suuny on 01-Dec-17.
 */
public class InsertCustomerdata {
    public  static String  getBranch(String branch)
    {
        String sql = "SELECT Branch_id FROM Branch Where Branch_name=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,branch);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString("Branch_id");
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
    public  static String  getLocation(String Location)
    {
        String sql = "SELECT location_id FROM Location Where street_address=? and post_code=? and city=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            String[] parts = Location.split(",");
            String x="";
          for(int i=0;i<parts.length-2;i++){

                x=x+parts[i];
                if(i!=parts.length-3){
                    x=x+",";
                }
          }
            pst.setString(1,x);
            pst.setString(2,parts[parts.length-2]);
            pst.setString(3,parts[parts.length-1]);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString("location_id");
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return String.valueOf("$");
    }
    public  static String  getid()
    {
        String sql = "SELECT count(*) FROM CUSTOMER";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {
                return rs.getString(1);
                // return Integer.getInteger(rs.toString());
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
    public  static void Inserdata(String username,String Password,String Email,String Phone,String Location, String Branch)
    {

        Branch=getBranch(Branch);
        // System.out.println(Branch);
        // Location=getLocation(Location);
        // System.out.println(Location);
        String  id=Integer.toString(Integer.parseInt(getid())+1001);
        // System.out.println(id);
        String sql = "INSERT INTO Customer (Customer_id,Customer_name,Email,Phone_number,Password,Location_id,Branch_id) VALUES (?,?,?,?,?,?,?)";

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,id);
            pst.setString(2,username);
            pst.setString(3,Email);
            pst.setString(4,Phone);
            pst.setString(5,Password);
            pst.setString(6,Location);
            pst.setString(7,Branch);
            pst.executeQuery();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Account created!");
            alert.setHeaderText("Account created Successfully!");
            alert.setContentText("Your customer id is "+id+".\nPlease remember the id to log into the system.");
            alert.showAndWait();

            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e+"now");
        }


    }
    public  static void InsertLocation(String a,String b,String c)
    {
        String sql = "insert into location values((select count(*) from location)+1,?,?,?)";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,a);
            pst.setString(2,b);
            pst.setString(3,c);
            // System.out.println(a+" "+b+" "+c);

            pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }
}
