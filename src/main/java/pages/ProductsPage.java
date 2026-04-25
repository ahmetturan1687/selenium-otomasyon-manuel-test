package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends BasePage {

    private final By searchInput         = By.id("search_product");
    private final By searchButton        = By.id("submit_search");
    private final By productCards        = By.cssSelector(".productinfo");
    private final By productNames        = By.cssSelector(".productinfo p");
    private final By addToCartButtons    = By.cssSelector("a.add-to-cart");
    private final By continueShoppingBtn = By.cssSelector("button.close-modal");
    private final By cartModal           = By.id("cartModal");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageLoaded() {
        try {
            waitForVisible(searchInput);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void searchProduct(String keyword) {
        dismissAds();
        type(searchInput, keyword);
        click(searchButton);
    }

    public int getProductCount() {
        return driver.findElements(productCards).size();
    }

    public List<WebElement> getProductNames() {
        return driver.findElements(productNames);
    }

    public boolean areSearchResultsDisplayed() {
        return getProductCount() > 0;
    }

    public void addFirstProductToCart() {
        dismissAds();
        List<WebElement> products = driver.findElements(productCards);
        if (!products.isEmpty()) {
            // Hover yaparak overlay'i göster
            new Actions(driver).moveToElement(products.get(0)).perform();
            // JS ile tıkla — reklam engeli bypass
            jsClick(addToCartButtons);
            // Modal'ın görünmesini bekle
            try {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(cartModal));
            } catch (Exception ignored) {}
        }
    }

    public void continueShopping() {
        try {
            jsClick(continueShoppingBtn);
            // Modal'ın kapanmasını bekle
            new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(cartModal));
        } catch (Exception ignored) {}
    }

    public CartPage viewCart() {
        jsClick(By.cssSelector("u"));
        return new CartPage(driver);
    }
}
