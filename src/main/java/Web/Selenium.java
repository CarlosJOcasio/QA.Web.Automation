package Web;

import Utility.Property;
import org.openqa.selenium.WebDriver;

abstract class Selenium {
    private static WebDriver driver;

    static void setWebDriver(WebDriver driver) {
        Selenium.driver = driver;
    }

    static WebDriver getWebDriver() {
        return driver;
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
        return Property.getProperty("./configuration/selenium.properties", key);
    }
}