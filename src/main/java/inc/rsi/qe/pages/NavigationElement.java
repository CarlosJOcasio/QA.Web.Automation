package inc.rsi.qe.pages;

import Web.Element;
import Web.LocatorType;
import org.openqa.selenium.By;

class NavigationElement extends Element {
    By getMenuButton() {
        return locate(LocatorType.cssSelector, "#mobile-navigation-trigger > span");
    }

    By getAboutUsLink() {
        return locate(LocatorType.cssSelector, "#menu-item-8094 > a");
    }
}