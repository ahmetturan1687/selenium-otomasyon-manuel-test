package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final By cartItems      = By.cssSelector("#cart_info_table tbody tr");
    private final By productNames   = By.cssSelector(".cart_description h4 a");
    private final By quantities     = By.cssSelector(".cart_quantity button");
    private final By deleteButtons  = By.cssSelector(".cart_quantity_delete");
    private final By emptyCartMsg   = By.id("empty_cart");
    private final By proceedCheckout = By.cssSelector(".check_out");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPageLoaded() {
        return driver.getCurrentUrl().contains("view_cart");
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public List<WebElement> getProductNames() {
        return driver.findElements(productNames);
    }

    public boolean isCartEmpty() {
        return isDisplayed(emptyCartMsg);
    }

    public void removeFirstItem() {
        List<WebElement> buttons = driver.findElements(this.deleteButtons);
        if (!buttons.isEmpty()) {
            int initialCount = getCartItemCount();
            buttons.get(0).click();
            // AJAX ile siliniyor — eleman kaybolana kadar bekle
            new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(d -> getCartItemCount() < initialCount || isCartEmpty());
        }
    }

    public void proceedToCheckout() {
        click(proceedCheckout);
    }
}
