package rsi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ABQDevelopmentCenter extends RuralSourcingWebSiteTest {

    @Test
    public void correctAlbuquerqueNewMexicoAddress() {
        chromeBrowser.openDefaultChrome();
        chromeBrowser.open(url);
        navigation.clickAboutUsLink();
        aboutPage.clickOurDevelopmentCentersButton();
        developmentCenters.clickNewMexicoButton();
        String address = developmentCenters.getAddressParagraph();
        Assert.assertEquals("Invalid address.", abqAddress, address);
    }
}