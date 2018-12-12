package schema;

import web.TestStep;
import java.util.List;

class Test {
    private String testCase;
    private List<TestStep> steps;

    String getTestCase() {
        return testCase;
    }

    List<TestStep> getSteps() {
        return steps;
    }
}