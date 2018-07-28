package rsi;

import org.junit.Assert;
import org.junit.Test;

public class ABQDevelopmentCenter extends RuralSourcingWebSiteTest {

    @Test
    public void correctAddress() {
        chromeBrowser.openFasterLoadChrome();
        chromeBrowser.open(url);
        navigation.clickAboutUsLink();
        aboutPage.clickOurDevelopmentCentersButton();
        developmentCenters.clickNewMexicoButton();
        String address = developmentCenters.getAddressParagraph();
        Assert.assertEquals("Invalid address.", abqAddress, address);
    }
}