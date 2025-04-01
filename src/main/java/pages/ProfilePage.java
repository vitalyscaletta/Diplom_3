package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//button[text()='Выход']")
    private WebElement logoutButton;

    @FindBy(xpath = "(//input[@class='text input__textfield text_type_main-default input__textfield-disabled'])[2]")
    private WebElement emailField;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Получение значения email из профиля пользователя")
    public String getEmailFromProfile() {
        waitForElementToBeVisible(emailField);
        return emailField.getAttribute("value");
    }

    @Step("Нажатие на кнопку 'Выход'")
    public void clickLogoutButton() {
        waitForElementToBeClickable(logoutButton);
        logoutButton.click();
    }
}