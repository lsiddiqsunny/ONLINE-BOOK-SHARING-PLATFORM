package Customer;

import Main.oracleDBMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userutil {
    public static String getOffer()
    {
        String sql = "select offer_details,to_char(offer_end,'DD-MM-YYYY') offer_end\n" +
                "from OFFER_DETAILS\n" +
                "where  MONTHS_BETWEEN(offer_end, sysdate)>0";

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
               StringBuffer s=new StringBuffer("");
               s=s.append(rs.getString("offer_details"));

               s=s.append(" \nBefore "+(rs.getString("offer_end")));
               String ano="";
               int co=1;
               for(int i=0;i<s.length();i++){
                   if(s.charAt(i)==' '){
                       co++;
                   }

                       ano=ano+(s.charAt(i));
                       if(co%5==0){
                           ano=ano+'\n';
                           co=1;
                       }

                  // System.out.println(co);
               }
               return ano;


            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {

        }
        return "";
    }
    public static List<List<String>> getHighrated()
    {
        String sql = "select  Book_name ,get_author_name(book_id) Author,rating  from book where rating is not null order by rating desc";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("Book_name"));
                row.add(rs.getString("Author"));
                if(rs.getString("rating")==null){
                    row.add("Rating: N/A");
                }
                else  row.add("Rating: "+rs.getString("rating"));

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

    public static List<List<String>> getlastadded()
    {
        String sql = "select  Book_name ,get_author_name(book_id) Author,rating  from book  order by add_date desc";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("Book_name"));
                row.add(rs.getString("Author"));
                if(rs.getString("rating")==null){
                    row.add("Rating: N/A");
                }
                else  row.add("Rating: "+rs.getString("rating"));

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
    public static List<List<String>> gettopsold()
    {
        String sql = "select  Book_name ,get_author_name(book_id) Author,rating  from book where total_sold <> 0 order by total_sold desc";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("Book_name"));
                row.add(rs.getString("Author"));
                if(rs.getString("rating")==null){
                    row.add("Rating: N/A");
                }
                else  row.add("Rating: "+rs.getString("rating"));

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
    public static List<List<String>> getAllBooks()
    {
        String sql = "select  Book_name ,get_author_name(book_id) Author,rating  from book";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("Book_name"));
                row.add(rs.getString("Author"));
                if(rs.getString("rating")==null){
                    row.add("Rating: N/A");
                }
                else  row.add("Rating: "+rs.getString("rating"));

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
}
