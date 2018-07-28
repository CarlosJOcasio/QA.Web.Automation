package inc.rsi.qe.pages;

import Web.WebPage;

public class DevelopmentCentersPage extends WebPage {
    private final DevelopmentCentersElement elements = new DevelopmentCentersElement();

    public void clickNewMexicoButton() {
        click(elements.getNewMexicoButton());
    }

    public String getAddressParagraph() {
        return getText(elements.getNewMexicoAddress());
    }
}