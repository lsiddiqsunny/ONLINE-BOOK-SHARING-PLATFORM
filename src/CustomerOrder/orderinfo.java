package CustomerOrder;

public class orderinfo {
    private final String orderid;
    private final String time;
    private final String status;
    private final String amount;
    private final String bookname;

    public orderinfo(String  a,String  b,String c,String d,String e) {
        this.orderid = new String(a);
        this.bookname = new String(b);
        this.amount= new String(c);
        this.time = new String(d);
        this.status = new String(e);

    }
    public String getBookname() {
        return bookname;
    }


    public String getAmount() {
        return amount;
    }

    public String getOrderid() {
        return orderid;
    }


    public String getTime() {
        return time;
    }


    public String getStatus() {
        return status;
    }

    public String toString() {
        return orderid+" - "+bookname+" - "+amount+" " +time+" - "+status;
    }
}
