package Web;

import org.openqa.selenium.By;

public abstract class WepPageComponent extends Selenium {

    //Tables
    //Navigators
    //Search
    //Drag And Drop

    protected void clickNavigatorLink(By menu, By link) {
        findElement(menu).click();
        findElement(link).click();
    }
}