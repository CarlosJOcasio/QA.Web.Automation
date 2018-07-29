package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Validation extends Selenium {
    private final Wait wait = new Wait();

    protected void compareEqual(By element, String text) {
        WebElement webElement = wait.presenceOf(element);
        wait.textToBe(element, text);
        String currentText = webElement.getText();
        boolean result = currentText.equals(text);
        assert result : String.format("Invalid element '%s' text, current: '%s' expected '%s'.", element, currentText, text);
    }

    protected void validateTitle(String text) {
        String title = getWebDriver().getTitle();
        boolean result = title.equals(text);
        assert result : String.format("Invalid page title, current: '%s' expected '%s'.", title, text);
    }
}
