package tests;
import base.BaseTest;
import config.ConfigReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class LoginTest extends BaseTest {

    ConfigReader config = new ConfigReader();

    @BeforeEach
    public void setup() {
        setUp();
        driver.get(config.getProperty("url"));
    }

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @AfterEach
    public void teardown() {
        tearDown();
    }
}