package Employee;

import Main.oracleDBMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class employeeutil {
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
}
