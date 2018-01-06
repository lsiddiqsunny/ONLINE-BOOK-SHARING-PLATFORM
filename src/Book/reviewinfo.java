package Book;

public class reviewinfo {
    private final String time;

    private final String username;
    private final String bookname;

    public reviewinfo(String  a,String  b,String c) {

        this.bookname = new String(c);
        this.username= new String(b);
        this.time = new String(a);

    }
    public String getBookname() {
        return bookname;
    }


    public String getUsername() {
        return username;
    }



    public String getTime() {
        return time;
    }



}
