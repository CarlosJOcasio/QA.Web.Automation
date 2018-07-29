package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Validation extends Selenium {
    private final Wait wait = new Wait();

    protected boolean compareEqual(By element, String text) {
        WebElement webElement = wait.presenceOf(element);
        wait.textToBe(element, text);
        return webElement.getText().equals(text);
    }

    protected boolean validateTitle(String text) {
        return getWebDriver().getTitle().equals(text);
    }
}
