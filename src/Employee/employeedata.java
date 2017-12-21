package Employee;

public class employeedata {
    private final String Employeename;
    private final String Phonenumber;
    private final String Jobname;

    public employeedata(String fName, String lName, String email) {
        this.Employeename = new String(fName);
        this.Phonenumber = new String(lName);
        this.Jobname= new String(email);
    }

    public String getEmployeename() {
        return Employeename;
    }


    public String getPhonenumber() {
        return Phonenumber;
    }


    public String getJobname() {
        return Jobname;
    }
    public String toString() {
        return Employeename+" - "+Phonenumber+" - "+Jobname;
    }


}
