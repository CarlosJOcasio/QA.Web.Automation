package web;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser extends Selenium implements IBrowser {

    //todo move commands to external files
    public void headleass() {
        chromeOptions().addArguments("--headless");
        normal();
    }

    private ChromeOptions chromeOptions;
    private ChromeOptions chromeOptions() {
        return chromeOptions = chromeOptions != null ? chromeOptions : new ChromeOptions();
    }

    @SuppressWarnings("SpellCheckingInspection")
    public void normal() {
        if(getWebDriver() == null) {
            System.setProperty("webdriver.chrome.driver", String.format("%s/chromedriver.exe", driversPath()));
            chromeOptions().addArguments("--start-maximized");
            setWebDriver(new ChromeDriver(chromeOptions()));
        }
    }

    public void fastLoad() {
        chromeOptions().addArguments("--disable-web-security");
        chromeOptions().addArguments("--disable-extensions");
        chromeOptions().addArguments("--disable-plugins");
        chromeOptions().addArguments("--incognito");
        chromeOptions().addArguments("--purge-memory-button");
        chromeOptions().addArguments("--enable-sandbox");
        normal();
    }

    public void open(TestStep step) {
        super.open(step);
    }

    public void close() {
        super.close();
    }

    @Override
    public String toString() {
        return "chrome";
    }
}