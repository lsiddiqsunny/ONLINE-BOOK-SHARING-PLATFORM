package Publisher;

public class BookEdit {
    private final String EditId;
    private final String BookName;
    private final String Price;
    private final String Status;
    public BookEdit(String fName, String lName,String c,String d) {
        this.EditId = new String(fName);
        this.BookName = new String(lName);
        this.Price = new String(c);
        this.Status= new String(d);
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
    public String toString() {
        return EditId+" - "+BookName;
    }
}
