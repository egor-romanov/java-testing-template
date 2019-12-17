package api.entities;

import java.util.ArrayList;

public class BaseResponse {

    public BaseResponse(LoginError error) {
        errors = new ArrayList<LoginError>();
        errors.add(error);
    }

    private ArrayList<LoginError> errors;

    public ArrayList<LoginError> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<LoginError> errors) {
        this.errors = errors;
    }
}
