package api.service;

import api.entities.BaseResponse;
import api.entities.RegisterResponse;
import api.model.UserRegisterInfo;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterService {

    @FormUrlEncoded
    @POST("api/register")
    Call<RegisterResponse> tryRegister(@Field("email") String email,
                                       @Field("password") String password,
                                       @Field("first_name") String first_name,
                                       @Field("last_name") String last_name,
                                       @Field("tz") String tz);
}