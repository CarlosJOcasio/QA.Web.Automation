package webDriver;

import org.junit.Test;
import webTesting.Inspection;

public class SanityTest extends Inspection {
    @Test
    public void headlessChromeInspection() {
        chromeBrowser.openHeadlessChrome();
        chromeBrowser.open("http://www.google.com");
    }

    @Test
    public void fastLoadChromeInspection() {
        chromeBrowser.openFasterLoadChrome();
        chromeBrowser.open("http://www.google.com");
    }

    @Test
    public void defaultChromeInspection() {
        chromeBrowser.openDefaultChrome();
        chromeBrowser.open("http://www.google.com");
    }
}