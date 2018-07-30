package schema;

import com.google.gson.Gson;
import web.TestStep;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class JsonParser {
    private Test test;

    void readFile(String path) throws IOException {
        Gson gson = new Gson();
        test = gson.fromJson(new FileReader(path), Test.class);
    }

    String getTestCase() {
        return test.getTestCase();
    }

    List<TestStep> getSteps() {
        return test.getSteps();
    }

    JsonParser getTest() {
        return this;
    }
}