package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "TC-UI-001: Başarılı kullanıcı girişi")
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.goToLoginPage();
        Assert.assertTrue(loginPage.isLoginPageLoaded(), "Login sayfası yüklenemedi");

        HomePage home = loginPage.loginWithCredentials(
                "ahmetturan1687@gmail.com",
                "3B58Hve35kc7@Cq"
        );

        Assert.assertTrue(home.isUserLoggedIn(), "Kullanıcı giriş yapamadı");
        System.out.println("Giriş yapan kullanıcı: " + home.getLoggedInUsername());
    }

    @Test(description = "TC-UI-002: Hatalı şifre ile giriş")
    public void testLoginWithWrongPassword() {
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.loginWithCredentials("ahmetturan1687@gmail.com", "YanlisŞifre123");

        Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Hata mesajı görünmüyor");
        String errorMsg = loginPage.getLoginError();
        Assert.assertTrue(
                errorMsg.contains("incorrect") || errorMsg.contains("not correct"),
                "Beklenmeyen hata mesajı: " + errorMsg
        );
    }

    @Test(description = "TC-UI-003: Kayıtlı olmayan e-posta ile giriş")
    public void testLoginWithUnregisteredEmail() {
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.loginWithCredentials("kayitli_degil_" + System.currentTimeMillis() + "@test.com", "3B58Hve35kc7@Cq");

        Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Hata mesajı görünmüyor");
    }

    @Test(description = "TC-UI-004: Başarılı çıkış")
    public void testLogout() {
        LoginPage loginPage = homePage.goToLoginPage();
        HomePage home = loginPage.loginWithCredentials(
                "ahmetturan1687@gmail.com",
                "3B58Hve35kc7@Cq"
        );
        Assert.assertTrue(home.isUserLoggedIn(), "Kullanıcı giriş yapamadı");

        home.logout();
        Assert.assertFalse(home.isUserLoggedIn(), "Çıkış sonrası kullanıcı hâlâ görünüyor");
    }
}
