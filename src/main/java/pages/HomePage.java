package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class HomePage extends BasePage {

    private final By loggedInUsername = By.cssSelector("a b");
    private final By logoutLink       = By.cssSelector("a[href='/logout']");
    private final By deleteAccLink    = By.cssSelector("a[href='/delete_account']");
    private final By homeSlider       = By.id("slider");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
        waitForPageLoad();
        dismissAds();
    }

    public boolean isHomePageLoaded() {
        return isDisplayed(homeSlider);
    }

    // Reklam engelini bypass etmek için direkt URL navigasyonu kullanıyoruz
    public LoginPage goToLoginPage() {
        driver.get(ConfigReader.get("base.url") + "/login");
        waitForPageLoad();
        dismissAds();
        return new LoginPage(driver);
    }

    public ProductsPage goToProductsPage() {
        driver.get(ConfigReader.get("base.url") + "/products");
        waitForPageLoad();
        dismissAds();
        return new ProductsPage(driver);
    }

    public CartPage goToCart() {
        driver.get(ConfigReader.get("base.url") + "/view_cart");
        waitForPageLoad();
        return new CartPage(driver);
    }

    public String getLoggedInUsername() {
        return getText(loggedInUsername);
    }

    public boolean isUserLoggedIn() {
        return isDisplayed(loggedInUsername);
    }

    public void logout() {
        dismissAds();
        click(logoutLink);
    }

    public void deleteAccount() {
        dismissAds();
        click(deleteAccLink);
    }
}
