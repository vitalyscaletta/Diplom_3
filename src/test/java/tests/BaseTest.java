package tests;

import models.User;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.*;
import steps.UserApiStep;
import webdriver.DriverManager;

import static steps.UserApiStep.retrieveAndSetAccessToken;

public class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected ProfilePage profilePage;
    protected RegistrationPage registrationPage;
    protected RestorePasswordPage restorePasswordPage;
    protected User user;
    protected UserApiStep userApiStep;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        user = new User();
        userApiStep = new UserApiStep();

        registrationPage = new RegistrationPage(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
    }

    @After
    public void tearDown() {
        retrieveAndSetAccessToken(user);
        if (user.getAccessToken() != null) {
            userApiStep.removeUser(user);
        }
            DriverManager.quitDriver();
    }
}