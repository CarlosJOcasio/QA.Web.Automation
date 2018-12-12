package web;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.Property;
import java.util.Arrays;

public class ChromeBrowser extends Selenium implements IBrowser {

    @SuppressWarnings("SpellCheckingInspection")
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
        Arrays.stream(Property.getProperty("./cmd/browser.properties", "cmd.chrome.browser.fast.load").split(";"))
                .forEach(cmd -> chromeOptions().addArguments(cmd));
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