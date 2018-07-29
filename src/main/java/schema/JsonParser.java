package schema;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

class Browser {
    String name;
    String description;
    String options;
}

class Step {
    String description = "";
    String name = "";
    String locatorType = "";
    String locator = "";
    String value = "";
}

class JsonParser {
    private Test test;

    void readFile(String path) throws IOException {
        Gson gson = new Gson();
        test = gson.fromJson(new FileReader(path), Test.class);
    }

    String getTestCase() {
        return test.getTestCase();
    }

    Browser[] getBrowser() {
        return test.getBrowsers();
    }

    String getUrl() {
        return test.getUrl();
    }

    Step[] getSteps() {
        return test.getSteps();
    }

    boolean closeBrowser() {
        return test.getCloseBrowser();
    }

    JsonParser getTest() {
        return this;
    }
}