package schema;

import org.junit.Assert;
import org.junit.Test;

public class JsonRunnerTest {

    @Test
    public void isMethodFound() {
        JsonRunner runner = new JsonRunner("");
        Assert.assertTrue(runner.isMethodFound(Web.WepPageComponent.class.getName(), "clickNavigatorLink"));
        Assert.assertFalse(runner.isMethodFound(Web.WebPage.class.getName(), "clickNavigatorLink"));
        Assert.assertFalse(runner.isMethodFound(Web.Validation.class.getName(), "clickNavigatorLink"));

        Assert.assertTrue(runner.isMethodFound(Web.WebPage.class.getName(), "click"));
        Assert.assertTrue(runner.isMethodFound(Web.Validation.class.getName(), "compareEqual"));
    }
}
