package Schema;

import com.google.common.io.Files;
import com.google.gson.JsonElement;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class JsonParser {
    public String getTestCase() {
        return "";
    }

    public String getBrowser() {
        return "";
    }

    public String getUrl() {
        return "";
    }

    public String[] getSteps() {
        return new String[]{};
    }

    public String[] getSnippets() {
        return new String[]{};
    }

    public boolean closeBrowser() {
        return true;
    }

    public void readFile(String path) throws IOException {
        JsonElement jelement = new JsonParser().parse(content);
    }

    public JsonTest getTest() {

        return new JsonTest();
    }

    private static String readLineByLineJava8(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) {

            stream.forEach(s -> contentBuilder.append(s).append("\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}