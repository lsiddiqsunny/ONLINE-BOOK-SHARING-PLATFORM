package Workspace;

public class offerinfo {
    private final String bookid;
    private final String authorname;
    private final String amount;
    private final String bookname;
    private final String per;

    public offerinfo(String  a,String  b,String c,String d,String e) {
        this.bookid = new String(a);
        this.bookname = new String(b);
        this.amount= new String(c);
        this.authorname = new String(d);
        this.per = new String(e);

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
    public String getPer() {
        return per;
    }

    @Override
    public String toString() {
        return authorname+" "+bookname;
    }
}
