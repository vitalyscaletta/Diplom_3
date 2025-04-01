package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonalAccountNavigationTest extends BaseTest {

    @Before
    public void setUpForUserLoginTest() {
        userApiStep.generateRandomUserData(user);
        userApiStep.createNewUser(user);
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет")
    @Description("Проверяет, что пользователь переходит на страницу личного кабинета после клика по кнопке 'Личный кабинет'.")
    public void testNavigateToPersonalAccount() {
        mainPage.clickAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.clickAccountButton();
        Assert.assertEquals(
                "Пользователь не авторизован!",
                user.getEmail(),
                profilePage.getEmailFromProfile()
        );
    }

    @Test
    @DisplayName("Проверка перехода по клику на 'Конструктор'")
    @Description("Проверяет, что пользователь возвращается на главную страницу после клика по кнопке 'Конструктор'.")
    public void testNavigateToConstructor() {
        mainPage.clickAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.clickAccountButton();
        mainPage.clickConstructorTab();

        Assert.assertTrue(
                "Заголовок 'Соберите бургер' не отображается после перехода на главную страницу!",
                mainPage.isHeaderDisplayed()
        );
    }

    @Test
    @DisplayName("Проверка перехода по клику на логотип Stellar Burgers")
    @Description("Проверяет, что пользователь возвращается на главную страницу после клика на логотип Stellar Burgers.")
    public void testNavigateToMainPageViaLogo() {
        mainPage.clickAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.clickAccountButton();
        mainPage.clickStellarBurgersLogo();

        Assert.assertTrue(
                "Заголовок 'Соберите бургер' не отображается после перехода на главную страницу!",
                mainPage.isHeaderDisplayed()
        );
    }
}
