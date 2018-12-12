package report;

public class Step {
    private String description, name, locatorType, locator, value;
    private boolean passed = true;

    public Step(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public Step(String description, String name, String value) {
        this(description, name);
        this.description = description;
        this.name = name;
        this.value = value;
    }

    public Step(String description, String name, String locatorType, String locator, String value, boolean passed) {
        this(description, name, value);
        this.locatorType = locatorType;
        this.locator = locator;
        this.passed = passed;
    }

    //todo simplify
    @Override
    public String toString() {
        StringBuilder html = new StringBuilder();
        html.append("<tr class=\"row100 body\">");
        html.append(String.format("<td class=\"cell100 column1\">%s</td>", description!=null && !description.isEmpty() ? description : ""));
        html.append(String.format("<td class=\"cell100 column2\">%s</td>", name!=null && !name.isEmpty() ? name : ""));
        html.append(String.format("<td class=\"cell100 column3\">%s</td>", locatorType!=null && !locatorType.isEmpty() ? locatorType : "" ));
        html.append(String.format("<td class=\"cell100 column4\">%s</td>", locator!=null && !locator.isEmpty() ? locator : ""));
        html.append(String.format("<td class=\"cell100 column5\">%s</td>", value!=null && !value.isEmpty() ? value : ""));
        html.append(String.format("<td class=\"cell100 column6\"><font color='%s'>%s</font></td></tr>", this.passed ? "green" : "red", this.passed ? "Passed" : "Failed"));

        return html.toString();
    }
}