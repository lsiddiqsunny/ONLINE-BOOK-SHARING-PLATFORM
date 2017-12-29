package Publisher;

import Main.oracleDBMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static Createaccount.InsertCustomerdata.getLocation;

public class publisherutil {
    public  static boolean  pendingbookinsert(String a,String b,String c,String d,String e,String f,String g) {
        String sql = "Insert into PENDINGBOOKINSERT values((select count(*) from PENDINGBOOKINSERT)+1,?,?,?,?,?,?,0,?)";
       // System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g);
        try {
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,a);
            pst.setString(2,b);
            pst.setString(3,c);
            pst.setString(4,d);
            pst.setString(5,e);
            pst.setString(6,f);
            pst.setString(7,g);
            System.out.println(pst.getParameterMetaData().toString());
            ResultSet rs = pst.executeQuery();


            pst.close();
            con.close();
            return true;
        } catch (Exception x) {
            System.out.println(x);
        } return false;
    }

    public  static String  getusername(String Publisher_id)
    {
        String sql = "SELECT Publisher_name FROM Publisher Where publisher_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Publisher_id);
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
    public static String getuserLocationid(String publisher_id)
    {
        String sql = "SELECT location_id FROM publisher Where Publisher_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,publisher_id);
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

            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                return rs.getString("Street_Address")+","+rs.getString("Post_code")+","+rs.getString("City")+".";


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
    public static List<List<String>> getAllAuthor()
    {
        String sql = "select  listedauthorid ,author_name from authorlist order by listedauthorid ";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("listedauthorid"));
                row.add(rs.getString("author_name"));

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
    public static List<List<String>> getAllBooks(String publisher_id)
    {
        String sql = "Select DISTINCT BOOK_NAME,GET_AUTHOR_NAME(b.book_id) AUTHOR_NAME,PRICE\n" +
                "from Book b,Publisher Pb,Author A\n" +
                "where b.publisher_id=Pb.PUBLISHER_ID and  b.publisher_id=? and b.book_id=A.book_id";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,publisher_id);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("BOOK_NAME"));
                row.add(rs.getString("AUTHOR_NAME"));
                row.add(rs.getString("PRICE"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {

        }
        return resultList;
    }

    public static List<List<String>> getbooktype()
    {
        String sql = "select book_type_name from book_type";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("book_type_name"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {

        }
        return resultList;
    }
    public static List<List<String>> getpublisherbook(String publisher_id)
    {
        String sql = "Select DISTINCT BOOK_NAME\n" +
                "from Book b,Publisher Pb,Author A\n" +
                "where b.publisher_id=Pb.PUBLISHER_ID and  b.publisher_id=? and b.book_id=A.book_id";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,publisher_id);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("BOOK_NAME"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {

        }
        return resultList;
    }
    public  static boolean  setName(String Name,String id,String Type) {
        String sql = "Update Publisher Set "+Type+"=? Where Publisher_id=?";
        // System.out.println(sql);
        try {
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, Name);
            pst.setString(2, id);
            ResultSet rs = pst.executeQuery();


            pst.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } return false;
    }

    public  static boolean  insertauthor(String Value) {
        String sql = "insert into authorlist values((select count(*) from authorlist)+1,?)";
        // System.out.println(sql);
        try {
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Value);

            ResultSet rs = pst.executeQuery();


            pst.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } return false;
    }
    public  static boolean  setPrice(String  Publisher,String id,String Value) {
        String sql = "Insert into PENDINGBOOKUPDATE values( (select count(*) from PENDINGBOOKUPDATE)+1,?,?,?,0)";
        // System.out.println(sql);
        try {
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Publisher);
            pst.setString(3, Value);
            pst.setString(2, id);
            ResultSet rs = pst.executeQuery();


            pst.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } return false;
    }
    public  static String  getBook(String book)
    {
        String sql = "SELECT Book_id FROM Book Where Book_name=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,book);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString("Book_id");
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
    public  static String  getType(String type)
    {
        String sql = "SELECT BOOK_TYPE_ID FROM BOOK_TYPE WHERE BOOK_TYPE_NAME LIKE '%"+type+"%'";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);


            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString("BOOK_TYPE_ID");
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
}
