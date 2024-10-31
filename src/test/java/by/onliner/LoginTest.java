package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void noRequiredFieldUsername() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.onliner.by/");
        driver.manage().window().fullscreen();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickButtonToFollowLoginForm();
        loginPage.sendKeysPassword("12345Ssa./");
        loginPage.clickButtonSignin();

        Assertions.assertEquals(LoginMessages.USERNAME_IS_REQUIRED, loginPage.getErrorMessageUsernameIsRequired());
    }

    @Test
    public void noRequiredFieldPassword() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.onliner.by/sdapi/user.api/login");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.sendKeysUsername("username");
        loginPage.clickButtonSignin();

        Assertions.assertEquals(LoginMessages.PASSWORD_IS_REQUIRED, loginPage.getErrorMessagePasswordIsRequired());
    }
}
