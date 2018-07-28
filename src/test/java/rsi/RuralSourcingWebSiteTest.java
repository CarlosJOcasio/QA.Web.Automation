package rsi;

import inc.rsi.qe.pages.AboutPage;
import inc.rsi.qe.pages.DevelopmentCentersPage;
import inc.rsi.qe.pages.NavigationComponent;
import webTesting.Inspection;

abstract class RuralSourcingWebSiteTest extends Inspection {
    static String url = "http://www.ruralsourcing.com/";
    static String abqAddress = "723 Silver Ave SW/nAlbuquerque, NM 87102/n505.218.8500";

    final NavigationComponent navigation = new NavigationComponent();
    final DevelopmentCentersPage developmentCenters = new DevelopmentCentersPage();
    final AboutPage aboutPage = new AboutPage();
}
