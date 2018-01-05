package Workspace;

public class bookinfo {
    private final String bookid;
    private final String authorname;
    private final String amount;
    private final String bookname;

    public bookinfo(String  a,String  b,String c,String d) {
        this.bookid = new String(a);
        this.bookname = new String(b);
        this.amount= new String(c);
        this.authorname = new String(d);


    }
    public String getBookname() {
        return bookname;
    }


    public String getAmount() {
        return amount;
    }

    public String getBookid() {
        return bookid;
    }


    public String getAuthorname() {
        return authorname;
    }


    public String toString() {
        return bookid +" - "+bookname+" - "+amount+" " + authorname;
    }
}
