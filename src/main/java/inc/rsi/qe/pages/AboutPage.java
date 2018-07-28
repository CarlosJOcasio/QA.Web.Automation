package inc.rsi.qe.pages;

import Web.WebPage;

public class AboutPage extends WebPage {
    private final AboutElement elements = new AboutElement();

    public void clickOurDevelopmentCentersButton() {
        click(elements.getOurDevelopmentCenters());
    }
}
