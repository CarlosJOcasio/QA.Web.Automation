package Web;

import org.openqa.selenium.WebDriver;

abstract class Driver {
    WebDriver driver;

    private WebDriver getWebDriver() {
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
}