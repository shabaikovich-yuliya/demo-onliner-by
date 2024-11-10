package by.onliner;

import org.junit.jupiter.api.*;
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
    @DisplayName("Тест 2 - Пустое поле логина")
    public void noRequiredFieldUsername() {
        this.loginPage.sendKeysPassword("12345Ssa./");
        this.loginPage.clickButtonSignin();

        Assertions.assertEquals(LoginMessages.USERNAME_IS_REQUIRED, this.loginPage.getErrorMessageUsernameIsRequired());
    }

    @Test
    @DisplayName("Тест 2 - Пустое поле пароля")
    public void noRequiredFieldPassword() {
        this.loginPage.sendKeysUsername("username");
        this.loginPage.clickButtonSignin();

        Assertions.assertEquals(LoginMessages.PASSWORD_IS_REQUIRED, this.loginPage.getErrorMessagePasswordIsRequired());
    }

    @Test
    @DisplayName("Тест 3 - Несуществующий пользователь")
    public void unregisteredUser() {
        this.loginPage.sendKeysUsername("username");
        this.loginPage.sendKeysPassword("pass123!");
        this.loginPage.clickButtonSignin();

        Assertions.assertEquals(LoginMessages.PASSWORD_IS_REQUIRED, this.loginPage.getErrorMessagePasswordIsRequired());
    }

    @AfterEach
    public void tearDown() {
        this.driver.quit();
    }
}


