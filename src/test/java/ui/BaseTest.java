package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;
import utils.ConfigReader;
import utils.DriverManager;

public class BaseTest {

    protected HomePage homePage;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        DriverManager.initDriver(browser);
        homePage = new HomePage(DriverManager.getDriver());
        homePage.open(ConfigReader.get("base.url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
