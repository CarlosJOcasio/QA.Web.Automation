package web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.URLDecoder;
import java.io.File;
import java.net.URL;

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

    protected void dragAndDropFile(String path, TestStep testStep) throws IOException {
        File filePath = new File(path);
        if (!filePath.exists()) {
            throw new WebDriverException("File not found " + filePath.toString());
        }

        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("scripts/DragDrop.js");
        assert url != null;

        //todo reduce

        String dragDropJs = FileUtils.readFileToString(new File(URLDecoder.decode(url.getFile(), "UTF-8")));

        WebElement target = getWebDriver().findElement(this.locate(LocatorType.valueOf(testStep.locatorType.split("&")[1]), testStep.locator.split("&")[1]));
        JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
        WebElement input = (WebElement) executor.executeScript(dragDropJs, target, 0, 0);
        input.sendKeys(filePath.getAbsoluteFile().toString());

        Wait wait = new Wait();
        wait.stalenessOf(input);
    }

    //Tables
    //Navigators
    //Search
    //Drag And Drop
    //Login
}