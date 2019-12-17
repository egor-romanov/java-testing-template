package pages;


import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SignUpPage {

    @Step("User enters {name}")
    public SignUpPage enterFirstName(String name) {
        $$("[data-test-id=\"register-form-name-input\"]")
            .filter(visible).shouldHaveSize(1).get(0)
            .$("input").val(name);
        return this;
    }

    @Step("User enters {name}")
    public SignUpPage enterLastName(String name) {
        $$("[data-test-id=\"register-last-name-input\"]")
            .filter(visible).shouldHaveSize(1).get(0)
            .$("input").val(name);
        return this;
    }

    @Step("User enters {login}")
    public SignUpPage enterLogin(String login) {
        $$("[aria-label=\"Auth Modal\"]")
            .filter(visible).shouldHaveSize(1).get(0)
            .$$("[name=\"email\"]")
            .filter(visible).shouldHaveSize(1).get(0)
            .val(login);
        return this;
    }

    @Step("User enters {pass}")
    public SignUpPage enterPassword(String pass) {
        $$("[data-test-id=\"register-password2-input\"]")
            .filter(visible).shouldHaveSize(1).get(0)
            .$("input").val(pass);
        return this;
    }

    @Step("User checks Terms And Policy")
    public SignUpPage checkTermsAndPolicy() {
        $$("label.Checkbox")
            .filter(visible).shouldHaveSize(1).get(0).click();
        return this;
    }

    @Step("User clicks log in button with invalid data")
    public SignUpPage clickEnterButtonWithError() {
        $$("button[data-test-id=\"register-submit-button\"]")
            .filter(visible).shouldHaveSize(1).get(0)
            .click();
        return this;
    }

    @Step("User gets error msg {errorMessage}")
    public void shouldBeError(String errorMessage) {
        $$(byText(errorMessage))
            .filter(visible).shouldHaveSize(1);
    }
}