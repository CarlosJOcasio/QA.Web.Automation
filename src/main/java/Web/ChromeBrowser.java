package Web;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser extends Selenium {

    public void openDefaultChrome() {
        if(getWebDriver() == null) {
            System.setProperty("webdriver.chrome.driver", String.format("%s/chromedriver.exe", driversPath()));
            chromeOptions().addArguments("--start-maximized");
            setWebDriver(new ChromeDriver(chromeOptions()));
        }
    }

    public void openHeadlessChrome() {
        chromeOptions().addArguments("--headless");
        openDefaultChrome();
    }

    public void openFasterLoadChrome() {
        chromeOptions().addArguments("--disable-extensions");
        chromeOptions().addArguments("--disable-plugins");
        chromeOptions().addArguments("--incognito");
        openDefaultChrome();
    }

    public void open(String url) {
        openDriver(url);
    }

    public void close() {
        closeDriver();
    }

    private ChromeOptions chromeOptions;
    private ChromeOptions chromeOptions() {
        return chromeOptions = chromeOptions != null ? chromeOptions : new ChromeOptions();
    }
}