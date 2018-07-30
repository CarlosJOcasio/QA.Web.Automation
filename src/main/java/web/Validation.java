package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Validation extends Selenium {
    private final Wait wait = new Wait();

    protected void compareEqual(TestStep testStep) {
        By element = this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator);
        WebElement webElement = wait.presenceOf(element);
        wait.textToBe(element, testStep.value);
        String currentText = webElement.getText();
        boolean result = currentText.equals(testStep.value);
        assert result : String.format("Invalid element '%s' text, current: '%s' expected '%s'.", element, currentText, testStep.value);
    }

    protected void validateTitle(TestStep testStep) {
        String title = getWebDriver().getTitle();
        boolean result = title.equals(testStep.value);
        assert result : String.format("Invalid page title, current: '%s' expected '%s'.", title, testStep.value);
    }
}