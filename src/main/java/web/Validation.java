package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Validation extends Selenium {
    private final Wait wait = new Wait();

    //todo move all messages to an external file.
    protected void compareEqual(TestStep testStep) {
        WebElement webElement = wait.presenceOf(testStep);
        boolean result = wait.textToBe(testStep, testStep.value);
        String currentText = result ? webElement.getText() : null;
        assert currentText != null && currentText.equals(testStep.value) : String.format("Invalid element '%s' text, current: '%s' expected '%s'.", testStep.name, currentText, testStep.value);
    }

    protected void validateTitle(TestStep testStep) {
        String title = getWebDriver().getTitle();
        assert title.equals(testStep.value) : String.format("Invalid page title, current: '%s' expected '%s'.", title, testStep.value);
    }

    protected void validateIsDisplayed(TestStep testStep) {
        By element = this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator);
        WebElement webElement = wait.presenceOf(testStep);
        assert webElement.isDisplayed() : String.format("Element '%s' is not displayed.", testStep.name);
    }

    protected void validateIsEnabled(TestStep testStep) {
        By element = this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator);
        WebElement webElement = wait.visibilityOf(testStep);
        assert webElement.isDisplayed() : String.format("Element '%s' is not enabled.", testStep.name);
    }

    protected void validateIsSelected(TestStep testStep) {
        By element = this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator);
        WebElement webElement = wait.presenceOf(testStep);
        assert webElement.isSelected() : String.format("Element '%s' is not selected.", testStep.name);
    }
}