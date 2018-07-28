package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class WebPage extends Selenium {
    private final Wait wait = new Wait();

    protected String getTitle() {
        return getWebDriver().getTitle();
    }

    protected void click(By element) {
        WebElement webElement = wait.canClick(element);
        webElement.click();
    }

    protected void enterText(By element, String text) {
        WebElement webElement = wait.canClick(element);
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void selectOption(By element, String option) {
        WebElement webElement = wait.canClick(element);
        Select select = new Select(webElement);
        select.deselectByVisibleText(option);
    }

    protected String getText(By element) {
        WebElement webElement = wait.presenceOf(element);
        return webElement.getText();
    }
}