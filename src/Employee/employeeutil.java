package Employee;

import Main.oracleDBMS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class employeeutil {
    public static List<List<String>> getAlloffer()
    {
        String sql = "select offer_details_id,offer_details,offer_start,offer_end,percentage from offer_details";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));

                row.add(rs.getString(4));
                row.add(rs.getString(5));
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
    public static List<List<String>> getAllTransport(String employee_id)
    {
        String sql = "select transport_Id,license,weight_capacity from transport where driver_id=?";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,employee_id);
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
        {
            System.out.println(e.toString());
        }
        return resultList;
    }
    public static List<List<String>> getMechanic(String Customer_id)
    {
        String sql = "select employee_id,employee_name from employee where branch_id=? and job_id=22";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));


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
    public static List<List<String>> getDriver(String Customer_id)
    {
        String sql = "select employee_id,employee_name from employee where branch_id=? and job_id=20";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));


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
    public static List<List<String>> getAssignedBook(String Id)
    {
        String sql = "select p.publisher_transaction_id,(select b.book_name from book b where b.book_id=p.book_id),\n" +
                "(select b.publisher_name from publisher b where b.PUBLISHER_ID=p.PUBLISHER_ID),\n" +
                "p.amount from PUBLISHER_TRANSACTION p where assignedto=?";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Id);
            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));

                row.add(rs.getString(4));

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
    public static List<List<String>> getReq(String Customer_id)
    {
        String sql = "select amount,book_id,publisher_id from bookrequest where request_id=?";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));

                resultList.add(row);
                return  resultList;
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
    public static List<List<String>> getWorker(String Customer_id)
    {
        String sql = "select employee_id ,employee_name from employee where branch_id =? and job_id=15";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));

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

    public static String getauthorname(String a)
    {
        String sql = "select author_name from authorlist where LISTEDAUTHORID=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,a);
            ResultSet rs = pst.executeQuery();

            while (rs.next())
            {

                return rs.getString(1);

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
    public static String getPublisherid1(String id)
    {
        String sql = "select DISTINCT  publisher_id from pendingbookinsert where pendingbookinsertid=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();

            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                return rs.getString(1);

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
    public static String getlastbook()
    {
        String sql = "select count(*) from book";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next())
            {

                return rs.getString(1);

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
    public static String gettype(String id)
    {
        String sql = "select distinct book_type_id from pendingbookinsert where pendingbookinsertid=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();

            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                return rs.getString(1);

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
    public static String getisbn(String id)
    {
        String sql = "select distinct isbn from pendingbookinsert where pendingbookinsertid=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();

            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                return rs.getString(1);

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

    public static List<List<String>> getInsertBook()
    {
        String sql = "select distinct pendingbookinsertid,book_name,get_new_author_name(pendingbookinsertid),price from pendingbookinsert where status=0";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));

                row.add(rs.getString(4));

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
    public static List<List<String>> getUpdateBook(String Customer_id)
    {
        String sql = "SELECT b.book_id, b.book_name,GET_AUTHOR_NAME(b.book_id),p.price \n" +
                "FROM pendingbookupdate p ,book b \n" +
                "WHERE b.book_id=p.book_id\n" +
                "AND b.storage_id=? and p.status=0\n";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));

                row.add(rs.getString(4));

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
    public static List<List<String>> getSReqBook(String Customer_id)
    {
        String sql = "select request_id,(select b.book_name from book b where b.book_id=r.book_id) ,get_author_name(r.book_id),GET_STATUS_EDIT(statues) \n" +
                "from bookrequest r where employee_id=? and (statues=0 or statues=1)";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));

                row.add(rs.getString(4));

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
    public static List<List<String>> getAssignBook(String Customer_id)
    {
        String sql = "SELECT DISTINCT p.Purchase_id,Get_Price(p.Purchase_id),GET_AMOUNT(p.Purchase_id) amount,(l.Street_address||','||l.post_code||','||l.city) Time,GET_STATUS(o.STATUS) STATUS\n" +
                "FROM Customer_purchase p,Customer_order o,Customer c,Location l \n" +
                "WHERE p.order_id=o.order_id AND o.customer_id=c.customer_id AND c.location_id=l.location_id AND o.ASSIGNEDTO=? AND o.status=2 ";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));

                row.add(rs.getString(4));
                row.add(rs.getString(5));
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
    public static List<List<String>> getAuthorList(String Customer_id)
    {
        String sql = "select author_id from pendingbookinsert where pendingbookinsertid=?";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));

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
    public static List<List<String>> getStorageBook(String Customer_id)
    {
        String sql = "select book_id,book_name,GET_AUTHOR_NAME(book_id) ,total_in_storage from book b,book_storage s,employee e \n" +
                "where e.BOOK_STORAGE_ID=s.STORAGE_ID and s.STORAGE_ID=b.STORAGE_ID and e.employee_id=? order by b.TOTAL_IN_STORAGE  ";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();


            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));

                row.add(rs.getString(4));

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
    public static List<List<String>> getAllBooks(String Customer_id)
    {
        String sql =
                "select distinct p.Purchase_id,Get_Price(p.Purchase_id),GET_AMOUNT(p.Purchase_id) amount,To_char(p.Purchas_Time,'dd/mm/yyyy') Time,GET_STATUS(o.STATUS) STATUS\n" +
                        "                from Customer_purchase p,Customer_order o,CUSTOMER c Where p.order_id=o.order_id and o.customer_id=c.CUSTOMER_ID and c.branch_id=?";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Customer_id);
            ResultSet rs = pst.executeQuery();

            // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));

                row.add(rs.getString(4));
                row.add(rs.getString(5));
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
    public static List<List<String>> getAllSelectedNotice(String job_id,String branch_id)
    {
        String sql = "SELECT NOTICE_ID,NOTICE,NOTICE_TIME,(SELECT JOB_NAME FROM JOB J WHERE J.JOB_ID=N.JOB_ID),GET_STATUS_NOTICE(ACTIVE) \n" +
                "FROM NOTICE N WHERE JOB_ID=? AND BRANCH_ID=?  ORDER BY ACTIVE DESC";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,job_id);
            pst.setString(2,branch_id);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
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
    public static List<List<String>> getAllNotice(String employee_id)
    {
        String sql = "SELECT NOTICE_ID,NOTICE,NOTICE_TIME,(SELECT JOB_NAME FROM JOB J WHERE J.JOB_ID=N.JOB_ID),GET_STATUS_NOTICE(ACTIVE)" +
                " FROM NOTICE N WHERE GIVENBY=?  ORDER BY ACTIVE DESC";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,employee_id);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
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
    public static void nullnotice()
    {
        String sql = "DELETE FROM NOTICE WHERE JOB_ID IS NULL";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);



            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void noticetojob(String sal,String ordered,String Employee_id,String d)
    {
        String sql = "INSERT INTO NOTICE VALUES((SELECT COUNT(*) FROM NOTICE)+1,?,SYSDATE,?,?,?,1)";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,sal);
            pst.setString(2,ordered);
            pst.setString(3,Employee_id);
            pst.setString(4,d);

            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void noticetoall(String sal,String ordered,String Employee_id)
    {
        String sql = "INSERT INTO NOTICE VALUES((SELECT COUNT(*) FROM NOTICE)+(select COUNT(JOB_ID) from employee e where manager_id=?)+1,?,SYSDATE,?,?,NULL,1)";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,ordered);
            pst.setString(2,sal);
            pst.setString(3,ordered);
            pst.setString(4,Employee_id);


            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static List<List<String>> getAllOrder(String employee_id)
    {
        String sql = "SELECT work_id,work_details,TO_CHAR(work_order_time,'DD/MM/YYYY'),(SELECT employee_name FROM employee e " +
                "WHERE e.employee_id=w.employee_id),GET_STATUS_WORK(work_status) FROM workinfo w WHERE OrderedBy=?";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,employee_id);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
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
    public static List<List<String>> getJoblist(String employee_id)
    {
        String sql = "select distinct (select j.job_name from job j where j.job_id=e.job_id) from employee e where manager_id=?";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,employee_id);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));

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
    public static int getusermaxsalary(String Employee_id)
    {
        String sql = "select j.max_salary from employee e,job j where e.job_id=j.job_id and e.employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   Integer.parseInt(rs.getString(1));
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }

    public static void updateusersalary(String sal,String Employee_id)
    {
        String sql = "update employee set salary=? where employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,sal);
            pst.setString(2,Employee_id);
            ResultSet rs = pst.executeQuery();


            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void updateusercommission(String sal,String Employee_id)
    {
        String sql = "update employee set commission_pct=? where employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,sal);
            pst.setString(2,Employee_id);
            ResultSet rs = pst.executeQuery();


            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void updateuserwork(String sal,String ordered,String Employee_id)
    {
        String sql = "insert into workinfo values ((select count(*) from workinfo)+1,SYSDATE,?,?,?,0)";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,sal);
            pst.setString(2,ordered);
            pst.setString(3,Employee_id);

            ResultSet rs = pst.executeQuery();


            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void updatework(String id)
    {
        String sql = "update workinfo set work_status=1 where work_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,id);


            ResultSet rs = pst.executeQuery();


            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void updatenotice(String id)
    {
        String sql = "update notice set active=0 where notice_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,id);


            ResultSet rs = pst.executeQuery();


            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void updatework1(String id)
    {
        String sql = "update workinfo set work_status=2 where work_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,id);


            ResultSet rs = pst.executeQuery();


            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static int getusersalary(String Employee_id)
    {
        String sql = "SELECT salary FROM Employee where employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   Integer.parseInt(rs.getString(1));
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }
    public static double getusercommission(String Employee_id)
    {
        String sql = "SELECT Commission_pct FROM Employee where employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   Double.parseDouble(rs.getString(1));
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }
    public static int getuserjobid(String Employee_id)
    {
        String sql = "SELECT job_id FROM Employee where employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   Integer.parseInt(rs.getString(1));
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }
    public static String getjobid(String Employee_id)
    {
        String sql = "select job_id from job where job_name=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return rs.getString(1);
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
    public  static boolean  setName(String Name,String id,String Type) {
        String sql = "Update Employee Set "+Type+"=? Where Employee_id=?";
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
    public  static String  getusername(String Employee_id)
    {
        String sql = "SELECT Employee_name FROM Employee Where Employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
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
    public static String getusermailphone(String Employee_id,String util)
    {
        String sql = "SELECT " +util +" FROM Employee Where Employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
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
    public static String getuserjob(String Employee_id)
    {
        String sql = "SELECT j.job_name FROM Employee e,job j Where e.job_id=j.job_id and  Employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
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
    public static String getuserdepartment(String Employee_id)
    {
        String sql = "SELECT d.department_name FROM Employee e,job j,Department d Where e.job_id=j.job_id and j.department_id=d.department_id" +
                " and  Employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
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
    public static List<List<String>> getAllEmployee(String employee_id)
    {
        String sql = "SELECT E.Employee_id id,E.EMPLOYEE_NAME Name,E.PHONE_NUMBER Phone,(SELECT J.JOB_NAME FROM JOB J WHERE E.JOB_ID=J.JOB_ID) JOB_NAME\n" +
                "FROM EMPLOYEE E\n" +
                "WHERE E.MANAGER_ID=?";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,employee_id);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("id"));
                row.add(rs.getString("Name"));
                row.add(rs.getString("Phone"));
                row.add(rs.getString("Job_name"));
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
    public static List<List<String>> getAllWork(String employee_id)
    {
        String sql = "SELECT work_id,work_details,TO_CHAR(work_order_time,'DD/MM/YYYY'),(SELECT employee_name FROM employee e " +
                "WHERE e.employee_id=w.orderedby),GET_STATUS_WORK(work_status) FROM workinfo w WHERE EMPLOYEE_ID=?";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,employee_id);
            ResultSet rs = pst.executeQuery();


            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
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

    public static String getusermanager(String Employee_id)
    {
        String sql = "SELECT E2.employee_NAME MANAGER\n" +
                "FROM EMPLOYEE E1 JOIN EMPLOYEE E2\n" +
                "ON (E1.MANAGER_ID = E2.EMPLOYEE_ID)\n" +
                "Where e1.employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
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
    public static String getuserLocationid(String Employee_id)
    {
        String sql = "SELECT location_id FROM Employee Where Employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
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
    public static String getPublisherid(String id)
    {
        String sql = "select publisher_id from book where book_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();

            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                return rs.getString(1);

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
    public static String getName(String id)
    {
        String sql = "select DISTINCT c.customer_name from customer_order o,customer_purchase p,customer c where p.order_id=o.order_id and c.customer_id=o.customer_id and p.purchase_id=?";

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();

            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                return rs.getString(1);

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
    public static String getuserBranch(String Employee_id)
    {
        String sql = "select branch_id from employee where employee_id=?";

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,Employee_id);
            ResultSet rs = pst.executeQuery();

            while (rs.next())
            {

                return rs.getString(1);
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
    public  static String  getBranch(String type)
    {
        String sql = "SELECT branch_id from employee where employee_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,type);


            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {

                return   rs.getString("branch_id");
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

    public  static void  changestatus1(String type)
    {


        String sql = " {call SET_STATUS1(?)}";
        try{
            Connection con = new oracleDBMS().getConnection();
            CallableStatement pst = con.prepareCall(sql);

            pst.setInt(1,Integer.parseInt(type));



            pst.executeQuery();


            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public  static void  updatebookprice(String id,String price)
    {


        String sql = "UPDATE book\n" +
                "SET price=" +price+"+"+price+"*.01"+
                "WHERE book_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareCall(sql);

            pst.setString(1,price);
            pst.setString(2,id);



            pst.executeQuery();


            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public  static void  assignorder(String id,String type)
    {


        String sql = " {call SET_SUPPLIERANDSTATUS(?,?)}";
        try{
            Connection con = new oracleDBMS().getConnection();
            CallableStatement pst = con.prepareCall(sql);
            pst.setInt(1,Integer.parseInt(id));
            pst.setInt(2,Integer.parseInt(type));
//System.out.println(type+ " "+id);


            pst.executeQuery();


            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public static void addbookreq(String a,String b,String c,String d)
    {
        String sql = "insert into bookrequest values( (select count(*) from bookrequest)+1,?,?,?,0,?)";

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,a);
            pst.setString(2,b);
            pst.setString(3,c);
            pst.setString(4,d);

            ResultSet rs = pst.executeQuery();

            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }
    public static void updatebookreq(String a)
    {
        String sql = "UPDATE pendingbookupdate p\n" +
                "SET status=1\n" +
                "WHERE p.book_id=?";

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,a);


            ResultSet rs = pst.executeQuery();

            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }
    public static void changestatus2(String a)
    {
        String sql = "UPDATE bookrequest\n" +
                "SET statues=2\n" +
                "WHERE request_id=?";

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,a);


            ResultSet rs = pst.executeQuery();

            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }
    public static void changestatus3(String a)
    {
        String sql = "UPDATE bookrequest\n" +
                "SET statues=3\n" +
                "WHERE request_id=?";

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,a);


            ResultSet rs = pst.executeQuery();

            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }

    public static void updatebookinsert(String a)
    {
        String sql = "UPDATE pendingbookinsert \n" +
                "SET status=1\n" +
                "WHERE pendingbookinsertid=?";

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,a);


            ResultSet rs = pst.executeQuery();

            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }
    public static void authorinsert(String name,String publisher,String storage)
    {
        String sql = "insert into author values(?,?,?) ";
        //  System.out.println(sql);

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,publisher);
            pst.setString(3,storage);


            ResultSet rs = pst.executeQuery();

            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }

    public static void addbookinsert(String name,String publisher,String storage,String isbn,String type,String price)
    {
        String sql = "insert into book values( (select count(*) from book)+1,?,"+price+
                "+"+price+"*.01,0,?,?,?,?,sysdate,null,0,?)";
        //  System.out.println(sql);

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,publisher);
            pst.setString(3,storage);
            pst.setString(4,isbn);
            pst.setString(5,type);
            pst.setString(6,price);

            ResultSet rs = pst.executeQuery();

            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }
    public static void transactioninsert(String a,String b,String c,String d,String e)
    {
        String sql = "INSERT INTO PUBLISHER_TRANSACTION VALUES\n" +
                "( (SELECT count(*) FROM PUBLISHER_TRANSACTION)+1 , ?,Sysdate,?,? ,0,?,?)";
        //  System.out.println(sql);

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,a);
            pst.setString(2,b);
            pst.setString(3,c);
            pst.setString(4,d);
            pst.setString(5,e);

            ResultSet rs = pst.executeQuery();

            pst.close();
            con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }

    }
    public  static String  getPublishername(String type)
    {
        String sql = "SELECT publisher_name from publisher where publisher_id=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,type);


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
        return null;
    }
    public static void updatepublishertransaction(String a)
    {
        String sql = "update PUBLISHER_TRANSACTION\n" +
                "set status=1\n" +
                "where PUBLISHER_TRANSACTION_ID=?";
        //  System.out.println(sql);

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,a);


            ResultSet rs = pst.executeQuery();

            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }

    public static void updatebookamount(String a,String b)
    {
        String sql = "\n" +
                "update book\n" +
                "set total_in_storage=total_in_storage+"+b+"\n" +
                "where book_id=?";
        //  System.out.println(sql);

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,a);


            ResultSet rs = pst.executeQuery();

            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }
    public static String getrequestid(String Employee_id)
    {
        String sql = "select request_id from PUBLISHER_TRANSACTION where PUBLISHER_TRANSACTION_ID=?";
        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,Employee_id);
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
    public static void offerinsert(String a,String b,String c,String d)
    {
        String sql = "insert into OFFER_DETAILS " +
                "values((select count(*) from offer_details)+1,?,To_date(?,'yyyy/mm/dd'),To_date(?,'yyyy/mm/dd'),?)";
        //  System.out.println(sql);

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,a);
            pst.setString(2,b);
            pst.setString(3,c);
            pst.setString(4,d);

            ResultSet rs = pst.executeQuery();

            pst.close();
            con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }

    }

}
