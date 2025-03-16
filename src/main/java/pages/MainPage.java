package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    // Личный кабинет
    @FindBy(xpath = "//a[@href='/account']")
    private WebElement accountButton;

    // Войти в аккаунт
    @FindBy(xpath = "//button[text()='Войти в аккаунт']")
    private WebElement loginButton;

    // Конструктор
    @FindBy(xpath = "//p[text()='Конструктор']")
    private WebElement constructorTab;

    // Лента заказов
    @FindBy(xpath = "//p[text()='Лента Заказов']")
    private WebElement orderFeedTab;

    // Заголовок "Соберите бургер"
    @FindBy(xpath = "//h1[text()='Соберите бургер']")
    private WebElement header;

    // Булки
    @FindBy(xpath = "//div[contains(@class, 'tab_tab__1SPyG')][1]")
    private WebElement bunsTab;

    // Соусы
    @FindBy(xpath = "//div[contains(@class, 'tab_tab__1SPyG')][2]")
    private WebElement saucesTab;

    // Начинки
    @FindBy(xpath = "//div[contains(@class, 'tab_tab__1SPyG')][3]")
    private WebElement fillingsTab;

    // Логотип Stellar Burgers
    @FindBy(xpath = "//div[@class='AppHeader_header__logo__2D0X2']")
    private WebElement stellarBurgersLogo;

    private static final String CURRENT_TAB_CLASS = "tab_tab_type_current__2BEPc";

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Нажатие на кнопку 'Личный кабинет'")
    public void clickAccountButton() {
        waitForElementToBeClickable(accountButton);
        accountButton.click();
    }

    @Step("Клик по логотипу Stellar Burgers")
    public void clickStellarBurgersLogo() {
        waitForElementToBeClickable(stellarBurgersLogo);
        stellarBurgersLogo.click();
    }

    @Step("Нажатие на кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        waitForElementToBeClickable(loginButton);
        loginButton.click();
    }

    @Step("Нажатие на вкладку 'Конструктор'")
    public void clickConstructorTab() {
        waitForElementToBeClickable(constructorTab);
        constructorTab.click();
    }

    @Step("Проверка отображения заголовка 'Соберите бургер'")
    public boolean isHeaderDisplayed() {
        return header.isDisplayed();
    }

    @Step("Нажатие на вкладку 'Булки'")
    public void clickBunsTab() {
        waitForElementToBeVisible(bunsTab);
        waitForElementToBeClickable(bunsTab);
        bunsTab.click();
    }

    @Step("Нажатие на вкладку 'Соусы'")
    public void clickSaucesTab() {
        waitForElementToBeClickable(saucesTab);
        saucesTab.click();
    }

    @Step("Нажатие на вкладку 'Начинки'")
    public void clickFillingsTab() {
        waitForElementToBeClickable(fillingsTab);
        fillingsTab.click();
    }

    @Step("Проверка активации вкладки 'Булки'")
    public boolean verifyBunsTabActive() {
        return bunsTab.getAttribute("class").contains(CURRENT_TAB_CLASS);
    }

    @Step("Проверка активации вкладки 'Соусы'")
    public boolean verifySaucesTabActive() {
        return saucesTab.getAttribute("class").contains(CURRENT_TAB_CLASS);
    }

    @Step("Проверка активации вкладки 'Начинки'")
    public boolean verifyFillingsTabActive() {
        return fillingsTab.getAttribute("class").contains(CURRENT_TAB_CLASS);
    }
}