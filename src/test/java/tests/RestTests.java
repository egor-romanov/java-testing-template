package tests;

import api.entities.BaseResponse;
import api.entities.RegisterResponse;
import api.model.User;
import api.util.JsonFileSource;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import rest.LoginActions;
import rest.RegisterActions;

import java.io.IOException;

@Feature("Проверка работоспособности api сервиса iq option")
@DisplayName("Проверка работоспособности api сервиса iq option")
public class RestTests {

    @Tag("param")
    @Story("LogIn")
    @DisplayName("Login test negative for user:")
    @ParameterizedTest(name ="{displayName} [{index}] {0}")
    @JsonFileSource( resources="/test_data_config/LoginRestNegative.json", type = User.class)
    public void loginTest(User user) throws IOException {
        LoginActions loginActions = new LoginActions();
        BaseResponse response = loginActions.tryLogin(user);
        loginActions.assertErrorMessageIs(user.getErrorMessage(), response);
    }

    @Tag("param")
    @Story("SignUp")
    @DisplayName("Sign up negative test for user:")
    @ParameterizedTest(name ="{displayName} [{index}] {0}")
    @JsonFileSource( resources="/test_data_config/SignUpNegative.json", type = User.class)
    public void signUp(User user) throws IOException {
        RegisterActions registerActions = new RegisterActions();
        RegisterResponse response = registerActions.tryRegister(user);
        registerActions.assertErrorMessageIs(user.getApiError(), user.getErrorField(), response);
    }
}
