package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestorePasswordPage extends BasePage {

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Поле для ввода email
    @FindBy(xpath = "//input[@name='name']")
    private WebElement emailInput;

    // Кнопка "Восстановить"
    @FindBy(xpath = "//button[text()='Восстановить']")
    private WebElement restoreButton;

    // Кнопка "Войти"
    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement loginButton;

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        loginButton.click();
    }
}
