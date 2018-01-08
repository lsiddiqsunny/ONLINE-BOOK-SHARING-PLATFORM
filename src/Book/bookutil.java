package Book;

import Main.oracleDBMS;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class bookutil {
    public static List<List<String>> getBookReview(String sitem)
    {
        sitem= sitem.toLowerCase();
        String sql = "select review_time,(select c.customer_name from customer c where c.customer_id=r.customer_id),review  from review r where book_id=?";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
pst.setString(1,sitem);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
               row.add(rs.getString(3));

                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {System.out.println(e.toString());

        }
        return resultList;
    }
    public static List<List<String>> getSearchBookbyauthor(String sitem)
    {
        sitem= sitem.toLowerCase();
        String sql = "select distinct b.Book_name Book_name,GET_AUTHOR_NAME(b.Book_id) Author,b.rating rating from book b,author a\n" +
                "where b.book_id=a.book_id and lower(a.author_name) LIKE '%"+sitem+"%' ";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                if(rs.getString(3)==null){
                    row.add("Rating: N/A");
                }
                else  row.add("Rating: "+rs.getString(3));

                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {System.out.println(e.toString());

        }
        return resultList;
    }
    public static List<List<String>> getSearchBookbytype(String sitem)
    {
        sitem= sitem.toLowerCase();
        String sql = "select distinct b.Book_name Book_name ,GET_AUTHOR_NAME(b.Book_id) Author,b.rating rating  from book b,book_type t\n" +
                "where b.book_type_id=t.book_type_id and Lower(t.book_type_name) LIKE '%"+sitem+"%' ";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                if(rs.getString(3)==null){
                    row.add("Rating: N/A");
                }
                else  row.add("Rating: "+rs.getString(3));

                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {System.out.println(e.toString());

        }
        return resultList;
    }
    public static List<List<String>> getSearchBookbybook(String sitem)
    {
       sitem= sitem.toLowerCase();
        String sql = "select distinct Book_name ,GET_AUTHOR_NAME(b.Book_id) Author,rating  from book b\n" +
                "where  lower(Book_name) LIKE '%"+sitem+"%' ";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                if(rs.getString(3)==null){
                    row.add("Rating: N/A");
                }
                else  row.add("Rating: "+rs.getString(3));

                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {System.out.println(e.toString());

        }
        return resultList;
    }
    public static String getOffer()
    {
        String sql = "select NVL(PERCENTAGE,0)\n" +
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


                // System.out.println(s);
                return  s;


            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {

        }
        return "0";
    }



    public static String getBookPrice(String book_name)
    {
        String sql = "select price\n" +
                "from book\n" +
                "where book_id=?";
        //  System.out.println(book_name);
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,book_name);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                String s=rs.getString(1);
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

    public static String getPurchase(String book_name)
    {
        String sql = "select purchase_id from customer_purchase where ORDER_ID=?";
        //  System.out.println(book_name);
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,book_name);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                String s=rs.getString(1);
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
        String sql = "select DISTINCT book_name,get_author_name(book_id) author,price,ISBN,(select t.book_type_name from book_type t where b.book_type_id=t.book_type_id) type,\n" +
                "total_in_storage\n" +
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
                l.add(rs.getString("total_in_storage"));
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
        String sql = "Insert into customer_order values ((select count(*) from customer_order)+1,sysdate,0,?,?,?,(select PERCENTAGE\n" +
                "from OFFER_DETAILS\n" +
                "                where  MONTHS_BETWEEN(offer_end, sysdate)>0 and MONTHS_BETWEEN(offer_start, sysdate)<0),null)";
          System.out.println(book_id);
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
    public static void insertreview(String book_id,String userid,String review,String rating)
    {
        String sql = "Insert into review values((select count(*) from review)+1,SYSDATE,?,?,?,?)";
        //  System.out.println(book_name);
        List<String>l=new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,review);
            pst.setString(2,userid);
            pst.setString(3,book_id);
            pst.setString(4,rating);
            pst.executeQuery();




            pst.close();
            con.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Review added");
            alert.setHeaderText("Review added Successfully!");
            alert.setContentText("Your Review Has Been Added Successfully");
            alert.showAndWait();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());

        }
    }
    public static boolean checkorder(String book_id,String am)
    {
        String sql = "SELECT ENOUGH_IN_STORE(?,?) \n" +
                "FROM BOOK\n" +
                "WHERE BOOK_ID=?";
        //  System.out.println(book_name);
        List<String>l=new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,am);

            pst.setString(2,book_id);
            pst.setString(3,book_id);
            pst.executeQuery();

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
               if(rs.getString(1).charAt(0)=='Y') return true;
               else return  false;

            }


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
        return  false;
    }
}
