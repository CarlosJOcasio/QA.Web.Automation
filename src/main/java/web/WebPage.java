package web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebPage extends Selenium {
    private final Wait wait = new Wait();

    protected void click(TestStep testStep) {
        WebElement webElement = wait.canClick(testStep);
        webElement.click();
    }

    protected void clearText(TestStep testStep) {
        WebElement webElement = wait.canClick(testStep);
        webElement.clear();
    }

    protected void enterText(TestStep testStep) {
        WebElement webElement = wait.canClick(testStep);
        webElement.clear();
        webElement.sendKeys(testStep.value);
    }

    protected String getText(TestStep testStep) {
        WebElement webElement = wait.presenceOf(testStep);
        return webElement.getText();
    }

    protected void selectOption(TestStep testStep) {
        WebElement webElement = wait.canClick(testStep);
        Select select = new Select(webElement);
        select.deselectByVisibleText(testStep.value);
    }

    protected void sendKeys(TestStep testStep) {
        WebElement webElement = wait.presenceOf(testStep);
        webElement.sendKeys(testStep.value);
    }
}