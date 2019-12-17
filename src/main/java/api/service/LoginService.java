package api.service;

import api.entities.BaseResponse;
import api.model.UserCreds;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("api/v1.0/login")
    Call<BaseResponse> login(@Body UserCreds user);
}