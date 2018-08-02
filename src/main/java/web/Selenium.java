package web;

import org.openqa.selenium.By;
import report.HTLMReport;
import utility.Property;
import org.openqa.selenium.WebDriver;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class Selenium {
    private static WebDriver driver;

    static void setWebDriver(WebDriver driver) {
        Selenium.driver = driver;
    }

    WebDriver getWebDriver() {
        return driver;
    }

    public void close() {
        try {
            getWebDriver().close();
            getWebDriver().quit();
        } catch (Exception ignored) {
        }
    }

    public void open(TestStep step) {
        getWebDriver().get(step.value);
    }

    //todo move paths to selenium.properties
    private String driversPath;
    String driversPath() {
        return driversPath = driversPath == null ? ClassLoader.getSystemResource("./bin/drivers").getFile() : driversPath;
    }

    private String property;
    String getProperty(String key) {
        return property = property != null ? property : Property.getProperty("./configuration/selenium.properties", key);
    }

    By locate(LocatorType type, String locator) {
        try {
            Class<?> clazz = Class.forName(org.openqa.selenium.By.class.getName());
            Method method = clazz.getMethod(type.toString(), String.class);
            return (By) method.invoke(clazz, locator);
        } catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|InvocationTargetException e) {
            HTLMReport.write(new report.Step("Exception", e.getMessage()));
            return null;
        }
    }
}