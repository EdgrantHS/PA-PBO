package Model;


public class Account extends Serializable {
    public String username;
    public String name;
    public String email;
    private String password;
    public int rating;

    public Account(String username, String name, String email, String password) {
        super();
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rating = 0;
    }
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getRating() {
        return rating;
    }
}
