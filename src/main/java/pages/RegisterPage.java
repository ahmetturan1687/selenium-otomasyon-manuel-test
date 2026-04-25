package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    private final By titleMr         = By.id("id_gender1");
    private final By passwordInput   = By.cssSelector("input[data-qa='password']");
    private final By daySelect       = By.cssSelector("select[data-qa='days']");
    private final By monthSelect     = By.cssSelector("select[data-qa='months']");
    private final By yearSelect      = By.cssSelector("select[data-qa='years']");
    private final By firstNameInput  = By.cssSelector("input[data-qa='first_name']");
    private final By lastNameInput   = By.cssSelector("input[data-qa='last_name']");
    private final By addressInput    = By.cssSelector("input[data-qa='address']");
    private final By countrySelect   = By.cssSelector("select[data-qa='country']");
    private final By stateInput      = By.cssSelector("input[data-qa='state']");
    private final By cityInput       = By.cssSelector("input[data-qa='city']");
    private final By zipcodeInput    = By.cssSelector("input[data-qa='zipcode']");
    private final By mobileInput     = By.cssSelector("input[data-qa='mobile_number']");
    private final By createAccButton = By.cssSelector("button[data-qa='create-account']");
    private final By accountCreated  = By.cssSelector("h2[data-qa='account-created']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillAccountDetails(String password, String day, String month, String year) {
        click(titleMr);
        type(passwordInput, password);
        new Select(driver.findElement(daySelect)).selectByValue(day);
        new Select(driver.findElement(monthSelect)).selectByVisibleText(month);
        new Select(driver.findElement(yearSelect)).selectByValue(year);
    }

    public void fillAddressDetails(String firstName, String lastName, String address,
                                   String country, String state, String city,
                                   String zipcode, String mobile) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(addressInput, address);
        new Select(driver.findElement(countrySelect)).selectByVisibleText(country);
        type(stateInput, state);
        type(cityInput, city);
        type(zipcodeInput, zipcode);
        type(mobileInput, mobile);
    }

    public void clickCreateAccount() {
        click(createAccButton);
    }

    public boolean isAccountCreated() {
        return isDisplayed(accountCreated);
    }
}
