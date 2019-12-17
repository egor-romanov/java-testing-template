package rest;

        import api.entities.BaseResponse;
        import api.entities.RegisterResponse;
        import api.model.User;
        import api.model.UserRegisterInfo;
        import api.service.RegisterService;
        import com.google.gson.Gson;
        import org.junit.jupiter.api.Assertions;
        import retrofit2.Response;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

        import java.io.IOException;

        import static constants.Constants.BASE_REGISTER_URL;

public class RegisterActions {

    private Retrofit retrofit;
    private RegisterService registerService;

    public RegisterActions() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_REGISTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        registerService = retrofit.create(RegisterService.class);
    }

    public RegisterResponse tryRegister(User user) throws IOException {
        UserRegisterInfo info = new UserRegisterInfo(user);
        Response<RegisterResponse> response = registerService.tryRegister(info.getEmail(),
                info.getPassword(),
                info.getFirst_name(),
                info.getLast_name(),
                info.getTz()).execute();
        return response.body();
    }

    public void assertErrorMessageIs(String msg, String field, RegisterResponse response) {
        Assertions.assertNotNull(response.getMessage(), "errors shouldn't be null");
        if (response.getMessage().isJsonArray()) {
            Assertions.assertEquals(1, response.getMessage().getAsJsonArray().size());
            Assertions.assertEquals(msg, response.getMessage().getAsJsonArray().get(0).getAsString());
            return;
        }
        String errorMessage = response.getMessage().getAsJsonObject()
                .getAsJsonArray(field).getAsJsonArray().get(0).getAsString();
        Assertions.assertEquals(msg, errorMessage);
    }
}
