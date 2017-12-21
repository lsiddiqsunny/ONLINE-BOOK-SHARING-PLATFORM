package Publisher;

public  class bookinfo {
    private final String Bookname;
    private final String Authorname;
    private final String Price;

    public bookinfo(String fName, String lName, String email) {
        this.Bookname = new String(fName);
        this.Authorname = new String(lName);
        this.Price = new String(email);
    }

    public String getBookname() {
        return Bookname;
    }


    public String getAuthorname() {
        return Authorname;
    }


    public String getPrice() {
        return Price;
    }

    public String toString() {
       return Bookname+" - "+Authorname+" - "+Price;
    }

}