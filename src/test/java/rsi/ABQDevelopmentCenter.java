package rsi;

import schema.Program;
import org.junit.Assert;
import org.junit.Test;
import webTesting.Inspection;
import java.io.IOException;

public class ABQDevelopmentCenter extends Inspection {

    @Test
    public void correctAlbuquerqueNewMexicoAddressUsingJsonSchema() throws IOException {
        int result = Program.main(new String[] {
                "-file: C:\\Users\\CarlosJ\\Documents\\RSI\\Automation\\WebDriver\\RSI.ABQ.QE.Automation\\src\\main\\java\\inc\\rsi\\qe\\rsi.site.address.test.json"
        });
        Assert.assertEquals(result, 0);
    }

    @Test
    public void findRSILinkInGoogleSearch() throws IOException {
        int result = Program.main(new String[] {
                "-file:'C:\\Users\\CarlosJ\\Documents\\RSI\\Automation\\WebDriver\\RSI.ABQ.QE.Automation\\src\\main\\java\\com\\google\\qe\\schemas\\google.site.rsi.search.test.json'",
                "-browser:chrome",
                "-options:fastLoad"
        });
        Assert.assertEquals(result, 0);
    }
}