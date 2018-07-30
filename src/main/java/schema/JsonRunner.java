package schema;

import report.HTLMReport;
import web.ChromeBrowser;
import web.TestStep;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;

class JsonRunner {
    private Date start = null;
    private final Option option = new Option();
    private final Browser browser = new Browser();
    private String browsers = "";
    private String options = "";
    private final String path;
    private final String webPageClassName = web.WebPage.class.getName();
    private final String chromeClassName = web.ChromeBrowser.class.getName();
    private final String validationClassName = web.Validation.class.getName();
    private final String webPageComponentClassName = web.WepPageComponent.class.getName();
    private final Invoke invoke = new Invoke();
    private JsonParser test;

    private JsonParser test() {
        return test = test != null ? test : init();
    }

    private ChromeBrowser chrome() {
        return new ChromeBrowser();
    }

    JsonRunner(String path, String browsers, String options) {
        this.path = path;
        this.browsers = browsers;
        this.options = options;
    }

    private JsonParser init() {
        JsonParser parser = new JsonParser();
        try {
            parser.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        start = new Date(System.currentTimeMillis());
        HTLMReport.write(new report.Step(parser.getTestCase(), "Initialize Test Case", start.toString()));
        browser.setBrowser(browsers);
        option.setOption(options);
        return parser.getTest();
    }

    private void setBrowser(Browser browser) {
        List<Option> options = option.getOptions();

        if (browser.toString().equalsIgnoreCase(chrome().toString())) {
            if (options.stream().anyMatch(o -> o.toString().contains("fastLoad"))) {
                chrome().fastLoad();
            } else if (options.stream().anyMatch(o -> o.toString().contains("headless"))) {
                chrome().headleass();
            } else {
                chrome().normal();
            }
        }
    }

    private void wrapUp(Browser browser) {
        if (browser.toString().equalsIgnoreCase(chrome().toString())) {
            chrome().close();
        }
    }

    void start() {
        test().getTestCase();
    }

    void end() {
        Date end = new Date(System.currentTimeMillis());
        HTLMReport.write(new report.Step("END TIME", "Test Suite Ended", end.toString()));

        long diff = TimeUnit.DAYS.convert(Math.abs(end.getTime() - start.getTime()), TimeUnit.MILLISECONDS);
        HTLMReport.write(new report.Step("TOTAL TIME", "Test Suite Total", String.valueOf(diff)));
    }

    private void runStep(TestStep step) {
        Exception exception = null;

        try {

            if (invokeMethod(webPageClassName, step.name, step) ||
                    invokeMethod(chromeClassName, step.name, step) ||
                    invokeMethod(validationClassName, step.name, step) ||
                    invokeMethod(webPageComponentClassName, step.name, step)) {

                Date end = new Date(System.currentTimeMillis());
                HTLMReport.write(new report.Step("END TIME", "Test Case Ended", end.toString()));
            }
        } catch (Exception | AssertionError exc) {
            exception = new Exception(exc.getCause());
        } finally {
            HTLMReport.write(new report.Step(
                    exception == null ? step.description : String.format("%s\nException: %s", step.description, exception.toString()),
                    step.name, step.locatorType, step.locator, step.value, exception == null));
        }

    }

    private void runSteps() {
        try {
            test().getSteps().stream().forEach(step -> {
                runStep(step);
            });
        } finally {
            wrapUp(browser);
        }
    }

    void runBrowser() {
        browser.getBrowsers().stream().forEach(b -> {
            setBrowser(b);
            runSteps();
        });
    }

    static boolean invokeMethod(String className, String methodName, TestStep step) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName(className);
        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
        Optional<Method> optionalMethod = methods.stream().filter(m -> m.getName().equalsIgnoreCase(methodName)).findFirst();
        Method method = optionalMethod.isPresent() ? optionalMethod.get() : null;

        boolean result = false;
        if(method != null) {
            method.setAccessible(true);
            if(method.getParameterCount() > 0) {
                method.invoke(clazz.newInstance(), step);
            } else {
                method.invoke(clazz.newInstance());
            }
            result = true;
        }

        return result;
    }
}