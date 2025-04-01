package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

    // Заголовок "Регистрация"
    @FindBy(xpath = "(//h2)[1]")
    private WebElement registrationHeader;

    // Поле "Имя"
    @FindBy(xpath = "(//input[@name='name'])[1]")
    private WebElement nameField;

    // Поле "Email"
    @FindBy(xpath = "(//input[@name='name'])[2]")
    private WebElement emailField;

    // Поле "Пароль"
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    // Кнопка "Зарегистрироваться"
    @FindBy(xpath = "(//button)[1]")
    private WebElement registerButton;

    // Кнопка "Войти"
    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement loginButton;

    // Кнопка "Некорректный пароль"
    @FindBy(xpath = "//p[text()='Некорректный пароль']")
    private WebElement incorrectPassword;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Ввод имени: {name}")
    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    @Step("Ввод email: {email}")
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    @Step("Ввод пароля: {password}")
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("Нажатие на кнопку 'Войти'")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Проверка отображения сообщения 'Некорректный пароль'")
    public boolean isIncorrectPasswordMessageDisplayed() {
        waitForElement(incorrectPassword);
        return incorrectPassword.isDisplayed();
    }

    @Step("Регистрация пользователя с именем: {name}, email: {email}, паролем: {password}")
    public void registerUser(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegisterButton();
    }
}