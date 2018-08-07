package web;

import org.openqa.selenium.Alert;
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

    boolean attributeContains(TestStep testStep) {
        return webDriverWait().until(ExpectedConditions.attributeContains(
                this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator), testStep.attribute, testStep.value));
    }

    WebElement canClick(TestStep testStep) {
        return webDriverWait().until(
                ExpectedConditions.elementToBeClickable(this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator)));
    }

    WebElement presenceOf(TestStep testStep) {
        return webDriverWait().until(
                ExpectedConditions.presenceOfElementLocated(this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator)));
    }

    boolean titleIs(String title) {
        return webDriverWait().until(ExpectedConditions.titleIs(title));
    }

    boolean textToBe(TestStep testStep, String text) {
        return webDriverWait().until(
                ExpectedConditions.textToBe(this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator),
                        text));
    }

    WebElement visibilityOf(TestStep testStep) {
        return webDriverWait().until(
                ExpectedConditions.visibilityOfElementLocated(this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator)));
    }

    boolean visibilityOf(String url) {
        return webDriverWait().until(ExpectedConditions.urlToBe(url));
    }

    List<WebElement> visibilityOfNestedElements(TestStep parent, TestStep child) {
        return webDriverWait().until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(
                this.locate(LocatorType.valueOf(parent.locatorType), parent.locator),
                this.locate(LocatorType.valueOf(child.locatorType), child.locator)));
    }
}