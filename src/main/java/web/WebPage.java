package web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebPage extends Selenium {
    private final Wait wait = new Wait();

    protected void click(TestStep testStep) {
        WebElement webElement = wait.canClick(this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator));
        webElement.click();
    }

    protected void enterText(TestStep testStep) {
        WebElement webElement = wait.canClick(this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator));
        webElement.clear();
        webElement.sendKeys(testStep.value);
    }

    protected void selectOption(TestStep testStep) {
        WebElement webElement = wait.canClick(this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator));
        Select select = new Select(webElement);
        select.deselectByVisibleText(testStep.value);
    }

    protected String getText(TestStep testStep) {
        WebElement webElement = wait.presenceOf(this.locate(LocatorType.valueOf(testStep.locatorType), testStep.locator));
        return webElement.getText();
    }
}