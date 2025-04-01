package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserRegistrationTest extends BaseTest {

    @Before
    public void setUpForUserLoginTest() {
        userApiStep.generateRandomUserData(user);
    }

    @Test
    @DisplayName("Успешная регистрация нового пользователя")
    @Description("Проверяет, что пользователь успешно регистрируется и перенаправляется в личный кабинет для проверки email.")
    public void testSuccessfulRegistration() {
        mainPage.clickAccountButton();
        loginPage.clickRegistrationButton();
        registrationPage.registerUser(user.getName(), user.getEmail(), user.getPassword());
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.clickAccountButton();
        Assert.assertEquals(
                "Пользователь не зарегистрирован (email'ы не совпадают)!",
                user.getEmail(),
                profilePage.getEmailFromProfile()
        );
    }

    @Test
    @DisplayName("Ошибка при регистрации с некорректным паролем")
    @Description("Проверяет, что ошибка отображается, если длина пароля меньше 6 символов.")
    public void testErrorForInvalidPassword() {
        mainPage.clickAccountButton();
        loginPage.clickRegistrationButton();
        registrationPage.registerUser(user.getName(), user.getEmail(), "false");
        Assert.assertTrue(
                "Сообщение о некорректном пароле не отображается.",
                registrationPage.isIncorrectPasswordMessageDisplayed()
        );
    }
}