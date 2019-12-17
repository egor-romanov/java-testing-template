package rest;

import api.entities.BaseResponse;
import api.model.User;
import api.model.UserCreds;
import api.service.LoginService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static constants.Constants.BASE_LOGIN_URL;

public class LoginActions {

    private Retrofit retrofit;
    private LoginService loginService;

    public LoginActions() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_LOGIN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        loginService = retrofit.create(LoginService.class);
    }

    public BaseResponse tryLogin(User user) throws IOException {
        Response<BaseResponse> response = loginService.login(new UserCreds(user)).execute();
        if (response.isSuccessful())
            return response.body();
        Gson gson = new Gson();
        String json = response.errorBody().string();
        return gson.fromJson(json, BaseResponse.class);
    }

    public void assertErrorMessageIs(String msg, BaseResponse response) {
        Assertions.assertNotNull(response.getErrors());
        Assertions.assertEquals(1, response.getErrors().size());
        Assertions.assertEquals(msg, response.getErrors().get(0).getTitle());
    }
}
