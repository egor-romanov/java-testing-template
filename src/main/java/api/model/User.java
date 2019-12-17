package api.model;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String errorMessage;

    private String apiError;

    private String errorField;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getErrorMessage() { return errorMessage; }

    public String getApiError() { return apiError; }

    public String getErrorField() { return errorField; }

    @Override
    public String toString() {
        return "User {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password=" + password +
                ", email=" + email +
                '}';
    }
}
