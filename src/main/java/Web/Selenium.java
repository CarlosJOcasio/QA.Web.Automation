package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.Properties;

abstract class Selenium {
    private static WebDriver driver;

    static void setWebDriver(WebDriver driver) {
        Selenium.driver = driver;
    }

    static WebDriver getWebDriver() {
        return driver;
    }

    WebElement findElement(By by) {
        return Selenium.getWebDriver().findElement(by);
    }

    void closeDriver() {
        getWebDriver().close();
    }

    void openDriver(String url) {
        getWebDriver().get(url);
    }

    private String driversPath;
    String driversPath() {
        return driversPath = driversPath == null ? ClassLoader.getSystemResource("./bin/drivers").getFile() : driversPath;
    }

    String getProperty(String key) {
        Properties property = new Properties();
        try {
            property.load(ClassLoader.getSystemResourceAsStream("./configuration/selenium.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property.getProperty(key);
    }
}