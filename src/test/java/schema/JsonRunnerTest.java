package schema;

import org.junit.Assert;
import org.junit.Test;

public class JsonRunnerTest {

    @Test
    public void isMethodFound() throws ClassNotFoundException {
        Assert.assertTrue(JsonRunner.isMethodFound(Web.WepPageComponent.class.getName(), "clickNavigatorLink"));
        Assert.assertFalse(JsonRunner.isMethodFound(Web.WebPage.class.getName(), "clickNavigatorLink"));
        Assert.assertFalse(JsonRunner.isMethodFound(Web.Validation.class.getName(), "clickNavigatorLink"));

        Assert.assertTrue(JsonRunner.isMethodFound(Web.WebPage.class.getName(), "click"));
        Assert.assertTrue(JsonRunner.isMethodFound(Web.Validation.class.getName(), "compareEqual"));
    }
}
