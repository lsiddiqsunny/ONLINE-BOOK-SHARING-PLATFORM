package Book;

import Main.oracleDBMS;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class bookutil {
    public static String getOffer()
    {
        String sql = "select PERCENTAGE\n" +
                "from OFFER_DETAILS\n" +
                "where  MONTHS_BETWEEN(offer_end, sysdate)>0";

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                String s="";
                s+=rs.getString("PERCENTAGE");

              s+="%";
              // System.out.println(s);
               return  s;


            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {

        }
        return "0%";
    }
    public static String getBookid(String book_name)
    {
        String sql = "select book_id\n" +
                "from book\n" +
                "where book_name like ?";
      //  System.out.println(book_name);
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,book_name);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                String s=rs.getString("book_id");
                return s;


            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {

        }
        return "";
    }
    public static List<String> getBookinfo(String book_id)
    {
        String sql = "select DISTINCT book_name,get_author_name(book_id) author,price,ISBN,(select t.book_type_name from book_type t where b.book_type_id=t.book_type_id) type\n" +
                "\n" +
                "from book b\n" +
                "where book_id=?";
        //  System.out.println(book_name);
         List<String>l=new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,book_id);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                l.add(rs.getString("book_name"));
               l.add(rs.getString("author"));
                l.add(rs.getString("price"));
                l.add(rs.getString("ISBN"));
                l.add(rs.getString("type"));
                return l;


            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {

        }
        return l;
    }
    public static void updateorder(String book_id,String am,String user)
    {
        String sql = "Insert into customer_order values ((select count(*) from customer_order)+1,sysdate,0,?,?,?)";
        //  System.out.println(book_name);
        List<String>l=new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,am);
            pst.setString(2,user);
            pst.setString(3,book_id);
            pst.executeQuery();




            pst.close();
            con.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Book added");
            alert.setHeaderText("Book added Successfully!");
            alert.setContentText("The book is added to your cart.");
            alert.showAndWait();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());

        }
    }
}
