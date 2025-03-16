package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserLoginTest extends BaseTest {

    @Before
    public void setUpForUserLoginTest() {
        userApiStep.generateRandomUserData(user);
        userApiStep.createNewUser(user);
    }

    @Test
    @DisplayName("Тест входа по кнопке «Войти в аккаунт» на главной")
    @Description("Проверяет, что пользователь может войти через кнопку «Войти в аккаунт» на главной странице.")
    public void testLoginViaMainPageLoginButton() {
        mainPage.clickLoginButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.clickAccountButton();
        Assert.assertEquals(
                "Пользователь не зарегистрирован (email'ы не совпадают)!",
                user.getEmail(),
                profilePage.getEmailFromProfile()
        );
    }

    @Test
    @DisplayName("Тест входа через кнопку «Личный кабинет»")
    @Description("Проверяет, что пользователь может войти через кнопку «Личный кабинет».")
    public void testLoginViaAccountButton() {
        mainPage.clickAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.clickAccountButton(); // Переход в профиль
        Assert.assertEquals(
                "Пользователь не зарегистрирован (email'ы не совпадают)!",
                user.getEmail(),
                profilePage.getEmailFromProfile()
        );
    }

    @Test
    @DisplayName("Тест входа через кнопку в форме регистрации")
    @Description("Проверяет, что пользователь может войти через кнопку входа в форме регистрации.")
    public void testLoginViaRegistrationFormButton() {
        mainPage.clickAccountButton();
        loginPage.clickRegistrationButton();
        registrationPage.clickLoginButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.clickAccountButton();
        Assert.assertEquals(
                "Пользователь не зарегистрирован (email'ы не совпадают)!",
                user.getEmail(),
                profilePage.getEmailFromProfile()
        );
    }

    @Test
    @DisplayName("Тест входа через кнопку в форме восстановления пароля")
    @Description("Проверяет, что пользователь может войти через кнопку входа в форме восстановления пароля.")
    public void testLoginViaPasswordRecoveryFormButton() {
        mainPage.clickAccountButton();
        loginPage.clickRestorePasswordButton();
        restorePasswordPage.clickLoginButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.clickAccountButton();
        Assert.assertEquals(
                "Пользователь не зарегистрирован (email'ы не совпадают)!",
                user.getEmail(),
                profilePage.getEmailFromProfile()
        );
    }
}