package tests;

import api.model.User;
import api.util.JsonFileSource;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.By;
import pages.HomePage;
import support.AllureSelenide;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.*;


@Feature("Проверка работоспособности ui сервиса iq option")
@DisplayName("Проверка работоспособности ui сервиса iq option")
public class IqOptionUiTests {

    HomePage homePage = new HomePage();

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void initDriver() {
        Configuration.timeout = BASE_TIMEOUT;
        Configuration.browserSize = BASE_BROWSER_SIZE;
        open(BASE_URL);
    }

    @AfterEach
    public void clear() {
        clearBrowserCookies();
    }

    @Tag("smoke")
    @Story("LogIn")
    @DisplayName("Log in negative:")
    @ParameterizedTest(name ="{displayName} [{index}] {0}")
    @JsonFileSource( resources="/test_data_config/LoginNegative.json", type = User.class)
    public void loginNegative(User user) {
        homePage.openLoginPage()
                .enterLogin(user.getEmail())
                .enterPassword(user.getPassword())
                .clickEnterButtonWithError()
                .shouldBeError();
    }

    @Tag("smoke")
    @Story("LogIn")
    @DisplayName("Log in positive:")
    @ParameterizedTest(name ="{displayName} [{index}] {0}")
    @JsonFileSource( resources="/test_data_config/LoginPositive.json", type = User.class)
    public void loginPositive(User user) {
        homePage.openLoginPage()
                .enterLogin(user.getEmail())
                .enterPassword(user.getPassword())
                .clickEnterButton()
                .userPageIsVisible();
    }

    @Tag("smoke")
    @Story("LogIn")
    @DisplayName("Log in invalid email:")
    @ParameterizedTest(name ="{displayName} [{index}] {0}")
    @JsonFileSource( resources="/test_data_config/LoginInvalidUserName.json", type = User.class)
    public void loginInvalidUserName(User user) {
        homePage.openLoginPage()
                .enterLogin(user.getEmail())
                .enterPassword(user.getPassword())
                .clickEnterButtonWithError()
                .shouldBeInvalidLogin();
    }

    @Tag("smoke")
    @Story("SignUp")
    @DisplayName("Sign up negative:")
    @ParameterizedTest(name ="{displayName} [{index}] {0}")
    @JsonFileSource( resources="/test_data_config/SignUpNegative.json", type = User.class)
    public void RegistrationNegative(User user) {
        homePage.openSignUpPage()
                .enterFirstName(user.getFirstName())
                .enterLastName(user.getLastName())
                .enterLogin(user.getEmail())
                .enterPassword(user.getPassword())
                .checkTermsAndPolicy()
                .clickEnterButtonWithError()
                .shouldBeError(user.getErrorMessage());
    }
}
