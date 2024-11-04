package by.onliner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setup() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.onliner.by/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        this.driver = driver;

        this.loginPage = new LoginPage(this.driver);
        this.loginPage.clickButtonToFollowLoginForm();
    }

    @Test
    public void noRequiredFieldUsername() {
        this.loginPage.sendKeysPassword("12345Ssa./");
        this.loginPage.clickButtonSignin();

        Assertions.assertEquals(LoginMessages.USERNAME_IS_REQUIRED, this.loginPage.getErrorMessageUsernameIsRequired());
    }

    @Test
    public void noRequiredFieldPassword() {
        this.loginPage.sendKeysUsername("username");
        this.loginPage.clickButtonSignin();

        Assertions.assertEquals(LoginMessages.PASSWORD_IS_REQUIRED, this.loginPage.getErrorMessagePasswordIsRequired());
    }

    @AfterEach
    public void tearDown() {
        this.driver.quit();
    }
}


