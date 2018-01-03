package Employee;

import Main.oracleDBMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class employeeutil {
    public static List<List<String>> getAllBooks(String Customer_id)
    {
        String sql = "select order_id,(select b.book_name from book b where b.book_id=o.book_id) book_name,amount,To_char(Time,'dd/mm/yyyy') Time,GET_STATUS(STATUS) STATUS\n" +
                "from Customer_order o ,Customer c where o.CUSTOMER_ID=c.CUSTOMER_ID and c.branch_id="+Customer_id+" ORDER BY STATUS";
        List<List<String>> resultList = new ArrayList<>();

        try{
            Connection con = new oracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

           // System.out.println(sql);
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("order_id"));
                row.add(rs.getString("book_name"));
                row.add(rs.getString("amount"));

                row.add(rs.getString("Time"));
                row.add(rs.getString("STATUS"));
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
}
