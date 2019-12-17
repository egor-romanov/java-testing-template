package api.model;

public class UserCreds {

    public UserCreds(User user) {
        email = user.getEmail();
        password = user.getPassword();
    }

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
