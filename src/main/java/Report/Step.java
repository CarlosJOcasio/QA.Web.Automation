package Report;

public class Step {
    private String description = "";
    private String name = "";
    private String locatorType = "";
    private String locator = "";
    private String value = "";
    private boolean passed = true;

    public Step(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public Step(String description, String name, boolean passed) {
        this(description, name);
        this.passed = passed;
    }

    Step(String description, String name, String locatorType, String locator) {
        this(description, name);
        this.description = description;
        this.name = name;
        this.locatorType = locatorType;
        this.locator = locator;
    }

    public Step(String description, String name, String locatorType, String locator, boolean passed) {
        this(description, name, locatorType, locator);
        this.passed = passed;
    }

    public Step(String description, String name, String locatorType, String locator, String value, boolean passed) {
        this(description, name, locatorType, locator);
        this.value = value;
        this.passed = passed;
    }

    @Override
    public String toString() {
        StringBuilder html = new StringBuilder();
        html.append("<tr class=\"row100 body\">");
        html.append(String.format("<td class=\"cell100 column1\">%s</td>", description));
        html.append(String.format("<td class=\"cell100 column2\">%s</td>", name));
        html.append(String.format("<td class=\"cell100 column3\">%s</td>", locatorType));
        html.append(String.format("<td class=\"cell100 column4\">%s</td>", locator));
        html.append(String.format("<td class=\"cell100 column5\">%s</td>", value));
        html.append(!this.passed ? "<td class=\"cell100 column6\"><font></font></td>" : "<td class=\"cell100 column6\"><font color='red'>Failed</font></td>");
        html.append("</tr>");

        return html.toString();
    }
}