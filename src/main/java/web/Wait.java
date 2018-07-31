package web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

class Wait extends Selenium {
    private final int timeout = Integer.parseInt(getProperty("wait.timeout.element.seconds"));

    private WebDriverWait wait;
    private WebDriverWait webDriverWait() {
        return wait = wait != null ? wait : new WebDriverWait(getWebDriver(), timeout);
    }

    Alert alertIsPresent() {
        return webDriverWait().until(ExpectedConditions.alertIsPresent());
    }

    boolean alertIsPresent(By element, String attribute, String value) {
        return webDriverWait().until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    WebElement canClick(By element) {
        return webDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    WebElement presenceOf(By element) {
        return webDriverWait().until(ExpectedConditions.presenceOfElementLocated(element));
    }

    boolean titleIs(String title) {
        return webDriverWait().until(ExpectedConditions.titleIs(title));
    }

    boolean textToBe(By element, String text) {
        return webDriverWait().until(ExpectedConditions.textToBe(element, text));
    }

    WebElement visibilityOf(By element) {
        return webDriverWait().until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    boolean visibilityOf(String url) {
        return webDriverWait().until(ExpectedConditions.urlToBe(url));
    }

    List<WebElement> visibilityOfNestedElements(By parent, By child) {
        return webDriverWait().until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parent, child));
    }
}