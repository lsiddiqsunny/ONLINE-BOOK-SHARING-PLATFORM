package Publisher;

public class BookRequest {
    private final String EditId;
    private final String BookName;
    private final String Price;
    private final String Status;
    private final String Branch;
    public BookRequest(String fName, String lName,String c,String d,String e) {
        this.EditId = new String(fName);
        this.BookName = new String(lName);
        this.Price = new String(c);
        this.Status= new String(d);
        this.Branch= new String(e);
    }

    public String getEditId() {
        return EditId;
    }


    public String getBookName() {
        return BookName;
    }
    public String getPrice() {
        return Price;
    }
    public String getStatus() {
        return Status;
    }
    public String getBranch() {
        return Branch;
    }
}
