package rsi;

import schema.Program;
import org.junit.Assert;
import org.junit.Test;
import webTesting.Inspection;
import java.io.IOException;

public class RSIOnlineTest extends Inspection {
    private final String path = "C:\\rsi\\github\\rsi.abq.qe.automation\\RSI.ABQ.QE.Automation\\src\\main\\java\\";

    @Test
    public void correctAlbuquerqueNewMexicoAddressUsingJsonSchema() throws IOException {
        int result = Program.main(new String[] {
                String.format("-file: %sinc\\rsi\\qe\\rsi.site.address.test.json", path)
        });
        Assert.assertEquals(result, 0);
    }

    @Test
    public void findRSILinkInGoogleSearch() throws IOException {
        int result = Program.main(new String[] {
                String.format("-file: %scom\\google\\qe\\schemas\\google.site.rsi.search.test.json'", path),
                "-browser:chrome",
                "-options:fastLoad"
        });
        Assert.assertEquals(result, 0);
    }
}