package Employee;

public class workinfo {
    private final String Details;
    private final String Ordertime;
    private final String Orderedby;
    private final String Id;
    private  final String Status;
    public workinfo(String x,String fName, String lName, String email,String y) {
        this.Id=x;
        this.Details = new String(fName);
        this.Ordertime= new String(lName);
        this.Orderedby= new String(email);
        this.Status=new String (y);
    }
    public String getId() {
        return Id;
    }
    public String getDetails() {
        return Details;
    }


    public String getOrdertime() {
        return Ordertime;
    }


    public String getOrderedby() {
        return Orderedby;
    }
    public String getStatus() {
        return Status;
    }
    public String toString() {
        return Details+" - "+Id+" - "+Orderedby;
    }


}
