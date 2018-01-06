package Workspace;

public class transportinfo {
    private final String Id;
    private final String Details;
   private  final String Status;
    public transportinfo(String x,String fName,String y) {
        this.Id=x;
        this.Details = new String(fName);
        this.Status=new String (y);
    }
    public String getId() {
        return Id;
    }
    public String getDetails() {
        return Details;
    }

    public String getStatus() {
        return Status;
    }
}
