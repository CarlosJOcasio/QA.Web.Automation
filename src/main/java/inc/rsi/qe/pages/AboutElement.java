package inc.rsi.qe.pages;

import Web.Element;
import Web.LocatorType;
import org.openqa.selenium.By;

public class AboutElement extends Element {
    By getOurDevelopmentCenters() {
        return locate(LocatorType.cssSelector, "#starts-and-stays > div.row.align-middle > div.columns.small-12.medium-7.large-4.large-offset-2.small-order-2.medium-order-1 > div > div > a");
    }
}
