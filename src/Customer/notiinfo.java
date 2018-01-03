package Customer;

public class notiinfo {
    private final String notiid;
    private final String notification;
    private final String time;



    public notiinfo(String  a,String  b,String c) {
        this.notiid = new String(a);
        this.notification = new String(b);

        this.time = new String(c);

    }
    public String getNotification () {
        return notification;
    }

    public String getNotiid() {
        return notiid;
    }


    public String getTime() {
        return time;
    }




    public String toString() {
        return notiid +" - "+notification+" - " +time+" - ";
    }

}
