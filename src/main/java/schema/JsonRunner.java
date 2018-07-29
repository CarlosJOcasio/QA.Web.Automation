package schema;

import Report.HTLMReport;
import Web.ChromeBrowser;
import Web.Element;
import Web.LocatorType;
import org.openqa.selenium.By;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class JsonRunner {
    private final String path;
    private final String webPageClassName = Web.WebPage.class.getName();
    private final String validationClassName = Web.Validation.class.getName();
    private final String webPageComponentClassName = Web.WepPageComponent.class.getName();

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

            try {
                for (Step step : test().getSteps()) {
                    Exception exception = null;

                    try {
                        By element;
                        if (isMethodFound(webPageClassName, step.name)) {
                            element = Element.locate(LocatorType.valueOf(step.locatorType), step.locator);
                            if (step.value.isEmpty()) {
                                invoke.method(webPageClassName, step.name, element);
                            } else {
                                invoke.method(webPageClassName, step.name, element, step.value);
                            }
                            continue;
                        }

                        if (isMethodFound(validationClassName, step.name)) {
                            if (!step.locatorType.isEmpty() && !step.locator.isEmpty() && !step.value.isEmpty()) {
                                element = Element.locate(LocatorType.valueOf(step.locatorType), step.locator);
                                invoke.method(validationClassName, step.name, element, step.value);
                            } else {
                                invoke.method(validationClassName, step.name, step.value);
                            }
                            continue;
                        }

                        if (isMethodFound(webPageComponentClassName, step.name)) {
                            String[] locatorTypes = step.locatorType.split(";");
                            String[] locators = step.locator.split(";");
                            invoke.method(webPageComponentClassName, step.name,
                                    Element.locate(LocatorType.valueOf(locatorTypes[0]), locators[0]),
                                    Element.locate(LocatorType.valueOf(locatorTypes[1]), locators[1]));
                        }
                    } catch (Exception | AssertionError exc) {
                        exception = new Exception(exc.getCause());
                    } finally {
                        HTLMReport.write(new Report.Step(
                                exception == null ? step.description : String.format("%s\nException: %s", step.description, exception.toString()),
                                step.name, step.locatorType, step.locator, step.value, exception == null));
                    }
                }
            } finally {
                chrome().close();
            }
        }
    }

    static boolean isMethodFound(String className, String methodName) throws ClassNotFoundException {
        Class<?> c = Class.forName(className);
        List<Method> methods = Arrays.asList(c.getDeclaredMethods());
        return methods.stream().anyMatch(string -> string.getName().contains(methodName));
    }
}