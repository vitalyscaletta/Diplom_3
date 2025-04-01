package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserLogoutTest extends BaseTest {

    @Before
    public void setUpForUserLoginTest() {
        userApiStep.generateRandomUserData(user);
        userApiStep.createNewUser(user);
    }

    @Test
    @DisplayName("Проверка выхода по кнопке 'Выйти'")
    @Description("Проверяет, что пользователь успешно выходит из аккаунта после нажатия на кнопку 'Выйти' в личном кабинете.")
    public void testLogoutFromPersonalAccount() {
        mainPage.clickAccountButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.clickAccountButton();
        profilePage.clickLogoutButton();

        Assert.assertTrue(
                "Пользователь не был перенаправлен на страницу логина после выхода!",
                loginPage.isLoginHeaderDisplayed()
        );
    }
}

