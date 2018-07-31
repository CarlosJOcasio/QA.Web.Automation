package web;

import org.openqa.selenium.WebElement;

public class WepPageComponent extends Selenium {
    private final Wait wait = new Wait();

    protected void clickNavigatorLink(TestStep testStep) {
        WebElement navigatorButton = wait.canClick(this.locate(LocatorType.valueOf(testStep.locatorType.split("&")[0]), testStep.locator.split("&")[0]));
        navigatorButton.click();
        WebElement navigatorLink = wait.canClick(this.locate(LocatorType.valueOf(testStep.locatorType.split("&")[1]), testStep.locator.split("&")[1]));
        navigatorLink.click();
    }

    //Tables
    //Navigators
    //Search
    //Drag And Drop
    //Login
}