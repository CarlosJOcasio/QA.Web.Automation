package webDriver;

import Web.ChromeBrowser;
import org.junit.After;
import org.junit.Before;

abstract class Inspection {
    ChromeBrowser chromeBrowser;

    @Before
    public void before() {
        chromeBrowser = new ChromeBrowser();
    }

    @After
    public void after() {
        chromeBrowser.close();
    }
}