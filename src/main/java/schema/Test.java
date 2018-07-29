package schema;

class Test {
    private String testCase;
    private Browser[] browsers;
    private String url;
    private Step[] steps;
    private String closeBrowser;

    String getTestCase() {
        return testCase;
    }

    Browser[] getBrowsers() {
        return browsers;
    }

    String getUrl() {
        return url;
    }

    Step[] getSteps() {
        return steps;
    }

    boolean getCloseBrowser() {
        return !closeBrowser.isEmpty();
    }
}