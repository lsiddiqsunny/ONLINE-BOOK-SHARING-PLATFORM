package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
//            for(String x: parts){
//                System.out.println(x);
//            }
            pst.setString(1,parts[0]);
            pst.setString(2,parts[1]);
            pst.setString(3,parts[2]);
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
        return null;
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
        Location=getLocation(Location);
       // System.out.println(Location);
        String  id=Integer.toString(Integer.parseInt(getid())+1001);
        System.out.print(id);
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


            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }
}
