package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Wait extends Selenium {
    private final int timeout = Integer.parseInt(getProperty("wait.timeout.element.seconds"));

    private WebDriverWait wait;
    private WebDriverWait webDriverWait() {
        return wait = wait != null ? wait : new WebDriverWait(getWebDriver(), timeout);
    }

    WebElement canClick(By element) {
        return webDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    WebElement presenceOf(By element) {
        return webDriverWait().until(ExpectedConditions.presenceOfElementLocated(element));
    }

    WebElement visibilityOf(By element) {
        return webDriverWait().until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    void textToBe(By element, String text) {
        webDriverWait().until(ExpectedConditions.textToBe(element, text));
    }
}