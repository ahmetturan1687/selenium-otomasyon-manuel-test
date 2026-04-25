package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Login formu
    private final By loginEmailInput    = By.cssSelector("input[data-qa='login-email']");
    private final By loginPasswordInput = By.cssSelector("input[data-qa='login-password']");
    private final By loginButton        = By.cssSelector("button[data-qa='login-button']");
    private final By loginErrorMessage  = By.cssSelector("p[style='color: red;']");

    // Signup formu
    private final By signupNameInput  = By.cssSelector("input[data-qa='signup-name']");
    private final By signupEmailInput = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton     = By.cssSelector("button[data-qa='signup-button']");
    private final By signupError      = By.xpath("//p[contains(text(),'Email Address already exist')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPageLoaded() {
        return isDisplayed(loginEmailInput);
    }

    public HomePage loginWithCredentials(String email, String password) {
        dismissAds();
        type(loginEmailInput, email);
        type(loginPasswordInput, password);
        click(loginButton);
        return new HomePage(driver);
    }

    public String getLoginError() {
        return getText(loginErrorMessage);
    }

    public boolean isLoginErrorDisplayed() {
        return isDisplayed(loginErrorMessage);
    }

    public RegisterPage startSignup(String name, String email) {
        type(signupNameInput, name);
        type(signupEmailInput, email);
        click(signupButton);
        return new RegisterPage(driver);
    }

    public boolean isSignupEmailError() {
        return isDisplayed(signupError);
    }
}
