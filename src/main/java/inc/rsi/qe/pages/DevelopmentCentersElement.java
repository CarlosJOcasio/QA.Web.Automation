package inc.rsi.qe.pages;

import Web.Element;
import Web.LocatorType;
import org.openqa.selenium.By;

class DevelopmentCentersElement extends Element {
    By getNewMexicoButton() {
        return locate(LocatorType.xpath, "//a[text()='New Mexico']");
    }

    By getNewMexicoAddress() {
        return locate(LocatorType.cssSelector, "#new-mexico > div > div.columns.small-12.medium-7.large-6.small-order-2.medium-order-2 > div > div > p:nth-child(2)");
    }
}