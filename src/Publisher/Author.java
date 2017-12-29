package Publisher;

public class Author {
    private final String AuthorId;
    private final String AuthorName;


    public Author(String fName, String lName) {
        this.AuthorId = new String(fName);
        this.AuthorName = new String(lName);

    }

    public String getAuthorId() {
        return AuthorId;
    }


    public String getAuthorName() {
        return AuthorName;
    }


    public String toString() {
        return AuthorId+" - "+AuthorName;
    }
}
