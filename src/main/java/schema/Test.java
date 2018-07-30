package schema;

import web.TestStep;
import java.util.List;

class Test {
    private String testCase;
    private String url;
    private List<TestStep> steps;

    String getTestCase() {
        return testCase;
    }

    String getUrl() {
        return url;
    }

    List<TestStep> getSteps() {
        return steps;
    }
}