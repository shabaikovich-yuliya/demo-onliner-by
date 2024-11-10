package by.onliner;

public class LoginXpath {
    public static final String INPUT_USERNAME_XPATH = "//div[@class='auth-form']//input[@type='text']";
    public static final String INPUT_PASSWORD_XPATH = "//div[@class='auth-form']//input[@type='password']";
    public static final String BUTTON_SIGNIN_XPATH = "//button[@class='auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full']";
    public static final String ERROR_MESSAGE_PASSWORD_IS_REQUIRED_XPATH = "//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']";
    public static final String ERROR_MESSAGE_USERNAME_IS_REQUIRED_XPATH = "//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']";
    public static final String ERROR_MESSAGE_INVALID_USERNAME_OR_PASSWORD_XPATH = "//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']";
    public static final String BUTTON_TO_FOLLOW_LOGIN_FORM_XPATH = "//div[@class='auth-bar__item auth-bar__item--text']";
}
