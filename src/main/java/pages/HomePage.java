package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    @Step("Open log in form")
    public LoginPage openLoginPage() {
        $("button[data-test-id=\"header-login-button\"]").click();
        return new LoginPage();
    }

    @Step("Open sign up form")
    public SignUpPage openSignUpPage() {
        $("button[data-test-id=\"header-register-button\"]").click();
            return new SignUpPage();
    }

}
