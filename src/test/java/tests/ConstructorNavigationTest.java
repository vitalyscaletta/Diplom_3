package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import webdriver.DriverManager;

public class ConstructorNavigationTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверяет, что переход к разделу 'Булки' работает корректно.")
    public void shouldNavigateToBunsSection() {
        mainPage.clickFillingsTab();
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        Assert.assertTrue("Переход на вкладку 'Булки' не произведён!", mainPage.verifyBunsTabActive());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Проверяет, что переход к разделу 'Соусы' работает корректно.")
    public void shouldNavigateToSaucesSection() {
        mainPage.clickSaucesTab();
        Assert.assertTrue("Переход на вкладку 'Соусы' не произведён!", mainPage.verifySaucesTabActive());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Проверяет, что переход к разделу 'Начинки' работает корректно.")
    public void shouldNavigateToFillingsSection() {
        mainPage.clickFillingsTab();
        Assert.assertTrue("Переход на вкладку 'Начинки' не произведён!", mainPage.verifyFillingsTabActive());
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
