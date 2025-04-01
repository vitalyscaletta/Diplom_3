package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Вход']")
    private WebElement loginHeader;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='Пароль']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text()='Зарегистрироваться']")
    private WebElement registrationButton;

    @FindBy(xpath = "//a[text()='Восстановить пароль']")
    private WebElement restorePasswordButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Ожидание заголовка 'Вход'")
    public void waitForLoginHeader() {
        waitForElementToBeVisible(loginHeader);
    }

    @Step("Ввод email: {email}")
    public void enterEmail(String email) {
        waitForLoginHeader();
        emailField.sendKeys(email);
    }

    @Step("Ввод пароля")
    public void enterPassword(String password) {
        waitForLoginHeader();
        passwordField.sendKeys(password);
    }

    @Step("Нажатие на кнопку 'Войти'")
    public void clickLoginButton() {
        waitForElementToBeClickable(loginButton);
        loginButton.click();
    }

    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        waitForElementToBeClickable(registrationButton);
        registrationButton.click();
    }

    @Step("Проверка наличия заголовка 'Вход'")
    public boolean isLoginHeaderDisplayed() {
        waitForLoginHeader();
        return loginHeader.isDisplayed();
    }

    @Step("Клик по кнопке 'Восстановить пароль'")
    public void clickRestorePasswordButton() {
        waitForElementToBeClickable(restorePasswordButton);
        restorePasswordButton.click();
    }

    @Step("Вход с email: {email} и паролем")
    public void loginUser(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}