package Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser extends Driver {

    public void openDefaultChrome() {
        startChromeDriver();
    }

    public void openHeadlessChrome() {
        chromeOptions().addArguments("--headless");
        startChromeDriver();
    }

    public void openFasterLoadChrome() {
        chromeOptions().addArguments("--disable-extensions");
        chromeOptions().addArguments("--disable-plugins");
        chromeOptions().addArguments("--incognito");
        startChromeDriver();
    }

    public void open(String url) {
        openDriver(url);
    }

    public void close() {
        closeDriver();
    }

    private ChromeOptions chromeOptions;
    ChromeOptions chromeOptions() {
        return chromeOptions = chromeOptions != null ? chromeOptions : new ChromeOptions();
    }

    WebDriver startChromeDriver() {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", String.format("%s/chromedriver.exe", driversPath()));
            chromeOptions().addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions());
        }
        return driver;
    }
}
