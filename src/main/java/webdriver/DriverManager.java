package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static constants.UrlConstants.BASE_URI;

public class DriverManager {

    private static WebDriver driver;
    private static final String URL = System.getProperty("test.url", BASE_URI);

    public static WebDriver getDriver() {
        if (driver == null || ((ChromeDriver) driver).getSessionId() == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        String browser = System.getProperty("browser", "chrome");
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "yandex":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setBinary(System.getProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe"));
                driver = new ChromeDriver(options);
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемый браузер: " + browser);
        }
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.manage().deleteAllCookies();
                driver.quit();
            } catch (Exception e) {
                System.err.println("Ошибка при завершении работы драйвера: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }
}
