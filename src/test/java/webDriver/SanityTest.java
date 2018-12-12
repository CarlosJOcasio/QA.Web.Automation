package webDriver;

import org.junit.Test;
import web.TestStep;
import webTesting.Inspection;

public class SanityTest extends Inspection {
    @Test
    public void headlessChromeInspection() {
        chromeBrowser.headleass();
        chromeBrowser.open(new TestStep("http://www.google.com"));
    }

    @Test
    public void fastLoadChromeInspection() {
        chromeBrowser.fastLoad();
        chromeBrowser.open(new TestStep("http://www.google.com"));
    }

    @Test
    public void defaultChromeInspection() {
        chromeBrowser.normal();
        chromeBrowser.open(new TestStep("http://www.google.com"));
    }
}