package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class LoginPage {

    @Step("User enters {login}")
    public LoginPage enterLogin(String login) {
        $$("[data-test-id=\"login-email-input\"]")
            .filter(visible).shouldHaveSize(1).get(0)
            .$("input").val(login);
        return this;
    }

    @Step("User enters {pass}")
    public LoginPage enterPassword(String pass) {
        $$("[data-test-id=\"login-password-input\"]")
            .filter(visible).shouldHaveSize(1).get(0)
            .$("input").val(pass);
        return this;
    }

    @Step("User clicks log in button with invalid data")
    public LoginPage clickEnterButtonWithError() {
        $$("button[data-test-id=\"login-submit-button\"]")
            .filter(visible).shouldHaveSize(1).get(0)
            .click();
        return this;
    }

    @Step("User clicks log in button")
    public UserPage clickEnterButton() {
        $$("button[data-test-id=\"login-submit-button\"]")
                .filter(visible).shouldHaveSize(1).get(0)
                .click();
        return new UserPage();
    }

    @Step("User gets error msg")
    public void shouldBeError() {
        $$("[data-test-id=\"login-error-block\"]")
            .filter(visible).shouldHaveSize(1).get(0)
            .shouldHave(text("Invalid login or password"));
    }

    @Step("User gets invalid email msg")
    public void shouldBeInvalidLogin() {
            $$(By.xpath("//span[contains(@class, 'iqInput__error')]"))
            .filter(visible).shouldHaveSize(1).get(0)
            .shouldHave(text("Invalid e-mail"));
    }
}

