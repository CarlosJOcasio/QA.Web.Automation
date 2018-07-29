package schema;

import Report.HTLMReport;
import Web.ChromeBrowser;
import Web.Element;
import Web.LocatorType;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class JsonRunner {
    private String path;

    private JsonParser test;
    private JsonParser test() throws IOException {
        return test = test != null ? test : init();
    }

    private ChromeBrowser chrome() {
        return new ChromeBrowser();
    }

    JsonRunner(String path) {
        this.path = path;
    }

    private JsonParser init() throws IOException {
        JsonParser parser = new JsonParser();
        parser.readFile(path);
        HTLMReport.write(new Report.Step(parser.getTestCase(), "Initialize Test Case"));
        return parser.getTest();
    }

    void runSteps() throws IOException {
        Invoke invoke = new Invoke();

        for(Browser browser : test().getBrowser()) {
            if(browser.name.equalsIgnoreCase(chrome().toString())) {
                chrome().openFasterLoadChrome();
                String url = test().getUrl();
                chrome().open(url);
                HTLMReport.write(new Report.Step("Open Chrome Browser", String.format("Opening url '%s'", url), true));
            }

            for(Step step : test().getSteps()) {
                Exception exception = null;

                try {
                    if (isMethodFound(Web.WebPage.class.getName(), step.name)) {
                        if (step.value.isEmpty()) {
                            invoke.method(
                                    Web.WebPage.class.getName(),
                                    step.name,
                                    Element.locate(LocatorType.valueOf(step.locatorType), step.locator)
                            );
                        } else {
                            invoke.method(
                                    Web.WebPage.class.getName(),
                                    step.name,
                                    Element.locate(LocatorType.valueOf(step.locatorType), step.locator),
                                    step.value
                            );
                        }
                        continue;
                    }

                    if (isMethodFound(Web.Validation.class.getName(), step.name)) {
                        if (!step.locatorType.isEmpty() && !step.locator.isEmpty() && !step.value.isEmpty()) {
                            invoke.method(
                                    Web.Validation.class.getName(),
                                    step.name,
                                    Element.locate(LocatorType.valueOf(step.locatorType), step.locator),
                                    step.value
                            );
                        } else {
                            invoke.method(
                                    Web.Validation.class.getName(),
                                    step.name,
                                    step.value
                            );
                        }
                        continue;
                    }

                    if (isMethodFound(Web.WepPageComponent.class.getName(), step.name)) {
                        String[] locatorTypes = step.locatorType.split(";");
                        String[] locators = step.locator.split(";");
                        invoke.method(
                                Web.WepPageComponent.class.getName(),
                                step.name,
                                Element.locate(LocatorType.valueOf(locatorTypes[0]), locators[0]),
                                Element.locate(LocatorType.valueOf(locatorTypes[1]), locators[1])
                        );
                    }
                } catch (Exception e) {
                    exception = e;
                } finally {
                    HTLMReport.write(new Report.Step(
                            exception == null ? step.description :
                                    String.format("Description %s\nException: %s\nStack: %s", step.description, exception.getMessage(), exception.toString()),
                                            step.name, step.locatorType, step.locator, step.value,exception == null));
                }
            }

            chrome().close();
        }
    }

    boolean isMethodFound(String className, String methodName) {
        try {
            Class<?> c = Class.forName(className);

            List<Method> methods = Arrays.asList(c.getDeclaredMethods());
            return methods.stream().anyMatch(string -> string.getName().contains(methodName));
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}