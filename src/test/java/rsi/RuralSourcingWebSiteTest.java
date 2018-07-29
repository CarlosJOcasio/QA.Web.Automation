package rsi;

import Utility.Property;
import inc.rsi.qe.pages.AboutPage;
import inc.rsi.qe.pages.DevelopmentCentersPage;
import inc.rsi.qe.pages.NavigationComponent;
import webTesting.Inspection;

abstract class RuralSourcingWebSiteTest extends Inspection {
    private static String getRSIProperty(String key) {
        return Property.getProperty("./rsi.properties", key);
    }

    final static String url = getRSIProperty("rsi.url");
    final static String abqAddress = getRSIProperty("rsi.abq.address");

    final NavigationComponent navigation = new NavigationComponent();
    final DevelopmentCentersPage developmentCenters = new DevelopmentCentersPage();
    final AboutPage aboutPage = new AboutPage();
}
