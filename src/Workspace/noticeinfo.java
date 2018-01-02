package Workspace;

public class noticeinfo {
    private final String Id;
    private final String Details;
    private final String Ordertime;
    private final String Orderedto;

    private  final String Status;
    public noticeinfo(String x,String fName, String lName, String email,String y) {
        this.Id=x;
        this.Details = new String(fName);
        this.Ordertime= new String(lName);
        this.Orderedto= new String(email);
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


    public String getOrderedto() {
        return Orderedto;
    }
    public String getStatus() {
        return Status;
    }
    public String toString() {
        return Details+" - "+Id+" - "+Orderedto;
    }
}
