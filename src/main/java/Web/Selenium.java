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
        try {
            getWebDriver().close();
        } catch (Exception ignored) { }
    }

    void openDriver(String url) {
        getWebDriver().get(url);
    }

    private String driversPath;
    String driversPath() {
        return driversPath = driversPath == null ? ClassLoader.getSystemResource("./bin/drivers").getFile() : driversPath;
    }

    private String property;
    String getProperty(String key) {
        return property = property != null ? property : Property.getProperty("./configuration/selenium.properties", key);
    }
}