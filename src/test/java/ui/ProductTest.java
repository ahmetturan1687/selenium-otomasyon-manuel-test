package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class ProductTest extends BaseTest {

    @Test(description = "TC-UI-005: Ürünler sayfasına gitme")
    public void testNavigateToProducts() {
        ProductsPage productsPage = homePage.goToProductsPage();
        Assert.assertTrue(productsPage.isProductsPageLoaded(), "Ürünler sayfası yüklenemedi");
        Assert.assertTrue(productsPage.getProductCount() > 0, "Ürün listesi boş");
        System.out.println("Toplam ürün sayısı: " + productsPage.getProductCount());
    }

    @Test(description = "TC-UI-006: Ürün arama — geçerli anahtar kelime")
    public void testSearchProductWithValidKeyword() {
        ProductsPage productsPage = homePage.goToProductsPage();
        productsPage.searchProduct("dress");

        Assert.assertTrue(productsPage.areSearchResultsDisplayed(), "Arama sonucu bulunamadı");
        System.out.println("'dress' araması sonuç sayısı: " + productsPage.getProductCount());
    }

    @Test(description = "TC-UI-007: Ürün arama — sonuç vermeyen kelime")
    public void testSearchProductWithNoResult() {
        ProductsPage productsPage = homePage.goToProductsPage();
        productsPage.searchProduct("xyzabc12345notexist");

        Assert.assertFalse(productsPage.areSearchResultsDisplayed(),
                "Var olmayan ürün için sonuç döndü");
    }

    @Test(description = "TC-UI-008: Sepete ürün ekleme")
    public void testAddProductToCart() {
        ProductsPage productsPage = homePage.goToProductsPage();
        Assert.assertTrue(productsPage.getProductCount() > 0, "Ürün bulunamadı");

        productsPage.addFirstProductToCart();
        productsPage.continueShopping();

        CartPage cartPage = homePage.goToCart();
        Assert.assertTrue(cartPage.isCartPageLoaded(), "Sepet sayfası açılmadı");
        Assert.assertTrue(cartPage.getCartItemCount() > 0, "Sepet boş, ürün eklenemedi");
        System.out.println("Sepetteki ürün sayısı: " + cartPage.getCartItemCount());
    }

    @Test(description = "TC-UI-009: Sepetten ürün silme")
    public void testRemoveProductFromCart() {
        // Önce sepete ürün ekle
        ProductsPage productsPage = homePage.goToProductsPage();
        productsPage.addFirstProductToCart();
        productsPage.continueShopping();

        CartPage cartPage = homePage.goToCart();
        int initialCount = cartPage.getCartItemCount();
        Assert.assertTrue(initialCount > 0, "Sepet zaten boş");

        cartPage.removeFirstItem();
        int newCount = cartPage.getCartItemCount();
        Assert.assertTrue(newCount < initialCount, "Ürün sepetten silinemedi");
    }
}
