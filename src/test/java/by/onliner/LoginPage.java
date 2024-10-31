package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonToFollowLoginForm() {
        By buttonToFollowLoginFormBy = By.xpath(LoginXpath.BUTTON_TO_FOLLOW_LOGIN_FORM_XPATH);
        WebElement buttonToFollowLoginFormWebElement = driver.findElement(buttonToFollowLoginFormBy);
        buttonToFollowLoginFormWebElement.click();
    }

    public void sendKeysUsername(String username) {
        By inputUsernameBy = By.xpath(LoginXpath.INPUT_USERNAME_XPATH);
        WebElement inputUsernameWebElement = driver.findElement(inputUsernameBy);
        inputUsernameWebElement.sendKeys(username);
    }

    public void sendKeysPassword(String password) {
        By inputPasswordBy = By.xpath(LoginXpath.INPUT_PASSWORD_XPATH);
        WebElement inputPasswordWebElement = driver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys(password);
    }

    public void clickButtonSignin() {
        By clickButtonSigninBy = By.xpath(LoginXpath.BUTTON_SIGNIN_XPATH);
        WebElement clicButtonSigninWebElement = driver.findElement(clickButtonSigninBy);
        clicButtonSigninWebElement.click();
    }

    public String getErrorMessagePasswordIsRequired() {
        By errorMessagePasswordIsRequiredBy = By.xpath(LoginMessages.PASSWORD_IS_REQUIRED);
        WebElement errorMessagePasswordIsRequiredWebElement = driver.findElement(errorMessagePasswordIsRequiredBy);
        return errorMessagePasswordIsRequiredWebElement.getText();
    }

    public String getErrorMessageUsernameIsRequired() {
        By errorMessageUsernameIsRequiredBy = By.xpath(LoginMessages.USERNAME_IS_REQUIRED);
        WebElement errorMessageUsernameIsRequiredWebElement = driver.findElement(errorMessageUsernameIsRequiredBy);
        return errorMessageUsernameIsRequiredWebElement.getText();
    }
}
