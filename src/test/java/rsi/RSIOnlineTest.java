package rsi;

import console.Program;
import org.junit.Assert;
import org.junit.Test;
import webTesting.Inspection;
import java.io.IOException;

public class RSIOnlineTest extends Inspection {
    //private final String path = "C:\\rsi\\github\\rsi.abq.qe.automation\\RSI.ABQ.QE.Automation\\src\\main\\java\\";
    private final String path = "C:\\Users\\CarlosJ\\Documents\\RSI\\Automation\\WebDriver\\RSI.ABQ.QE.Automation";

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
                String.format("-file: %s\\Schema\\test\\google.site.rsi.search.test.json'", path),
                "-report:C:\\Results\\",
                "-browser:chrome",
                "-options:fastLoad"
        });
        Assert.assertEquals(0, result);
    }
}