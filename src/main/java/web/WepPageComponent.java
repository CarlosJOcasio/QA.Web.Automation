package web;

import org.openqa.selenium.WebElement;

public class WepPageComponent extends Selenium {
    private final Wait wait = new Wait();

    protected void clickNavigatorLink(TestStep testStep) {
        TestStep parent = testStep;
        parent.locatorType = testStep.locatorType.split("&")[0];
        parent.locator = testStep.locator.split("&")[0];
        WebElement navigatorButton = wait.canClick(parent);
        navigatorButton.click();

        TestStep child = testStep;
        child.locatorType = testStep.locatorType.split("&")[1];
        child.locator = testStep.locator.split("&")[1];
        WebElement navigatorLink = wait.canClick(child);
        navigatorLink.click();
    }

    //Tables
    //Navigators
    //Search
    //Drag And Drop
    //Login
}