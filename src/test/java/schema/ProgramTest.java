package schema;

import console.Program;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class ProgramTest {

    @Test
    public void commandLineTest() throws IOException {
        int result = Program.main(new String[] {
                "-browser:chrome",
                "-options:fastLoad"
        });

        Assert.assertEquals(result,1);

        result = Program.main(new String[] {
                "-file:c:\\test.test.json"
        });

        Assert.assertEquals(result,1);
    }
}