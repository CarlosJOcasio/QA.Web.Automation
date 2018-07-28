package webTesting;

import Web.ChromeBrowser;
import org.junit.After;
import org.junit.Before;

public abstract class Inspection {
    protected ChromeBrowser chromeBrowser;

    @Before
    public void before() {
        chromeBrowser = new ChromeBrowser();
    }

    @After
    public void after() {
        chromeBrowser.close();
    }
}