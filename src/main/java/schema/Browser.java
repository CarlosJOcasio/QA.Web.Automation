package schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Browser {
    Browser() { }

    private String name;
    private Browser(String name) {
        this.name = name;
    }

    private final List<Browser> browsers = new ArrayList<Browser>(){};
    List<Browser> getBrowsers() { return browsers; }

    private String browser;
    private String getBrowser() {
        return browser;
    }

    void setBrowser(String browser) {
        this.browser = browser;
        Arrays.stream(getBrowser().split("&")).forEach(b -> getBrowsers().add( new Browser(b) ));
    }

    @Override
    public String toString() {
        return name;
    }
}