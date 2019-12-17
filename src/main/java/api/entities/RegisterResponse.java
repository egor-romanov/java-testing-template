package api.entities;

import com.google.gson.JsonElement;

import java.util.ArrayList;

public class RegisterResponse {

    private boolean isSuccessful;
    private JsonElement message;
    private String result;
    private int code;
    private ArrayList<Integer> codeList;

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public JsonElement getMessage() {
        return message;
    }

    public void setMessage(JsonElement message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<Integer> getCodeList() {
        return codeList;
    }

    public void setCodeList(ArrayList<Integer> codeList) {
        this.codeList = codeList;
    }
}
