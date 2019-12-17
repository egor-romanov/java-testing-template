package api.model;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRegisterInfo {

    public UserRegisterInfo(User user) {
        first_name = user.getFirstName();
        last_name = user.getLastName();
        email = user.getEmail();
        password = user.getPassword();
    }

    private String first_name;

    private String last_name;

    private String email;

    private String password;

    private String tz = "Europe/Moscow";

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTz() {
        return tz;
    }
}
