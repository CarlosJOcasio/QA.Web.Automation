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
                "-file: "+path+"inc\\rsi\\qe\\rsi.site.address.test.json"
        });
        Assert.assertEquals(result, 0);
    }

    @Test
    public void findRSILinkInGoogleSearch() throws IOException {
        int result = Program.main(new String[] {
                "-file: "+path+"com\\google\\qe\\schemas\\google.site.rsi.search.test.json'",
                "-browser:chrome",
                "-options:fastLoad"
        });
        Assert.assertEquals(result, 0);
    }
}