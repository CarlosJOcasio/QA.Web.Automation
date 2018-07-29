package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class WepPageComponent extends Selenium {
    private final Wait wait = new Wait();

    protected void clickNavigatorLink(By menu, By link) {
        WebElement navigatorButton = wait.canClick(menu);
        navigatorButton.click();
        WebElement navigatorLink = wait.canClick(link);
        navigatorLink.click();
    }

    //Tables
    //Navigators
    //Search
    //Drag And Drop
}