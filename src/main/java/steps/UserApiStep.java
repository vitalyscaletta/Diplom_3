package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;

import static constants.UrlConstants.BASE_URI;
import static constants.UrlConstants.USER_BASE_PATH;
import static io.restassured.RestAssured.given;

public class UserApiStep {

    @Step("Генерация случайных данных пользователя")
    public void generateRandomUserData(User user) {
        user.setEmail((RandomStringUtils.randomAlphabetic(5)
                .toLowerCase()) + "@test.com");
        user.setPassword(RandomStringUtils.randomAlphabetic(8));
        user.setName(RandomStringUtils.randomAlphabetic(8));
    }

    @Step("Получение токена авторизации")
    public static void retrieveAndSetAccessToken(User user) {
        String accessToken = loginUserRequest(user).extract()
                .body().path("accessToken");
        user.setAccessToken(accessToken);
    }

    @Step("Создание нового пользователя")
    public void createNewUser(User user) {
        given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .when()
                .post(USER_BASE_PATH + "/register")
                .then();
    }


    @Step("Вход пользователя в систему")
    public static ValidatableResponse loginUserRequest(User user) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .when()
                .post(USER_BASE_PATH + "/login")
                .then();
    }

    @Step("Удаление пользователя")
    public void removeUser(User user) {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", user.getAccessToken())
                .baseUri(BASE_URI)
                .when()
                .delete(USER_BASE_PATH + "/user")
                .then();
    }
}