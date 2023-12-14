package Model;

public class Account extends Serializable {
    public String name;
    public String email;
    private String password;
    public int rating;

    public Account(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.rating = 0;
    }
}
