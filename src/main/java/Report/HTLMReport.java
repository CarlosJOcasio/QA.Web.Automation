package Report;

public class HTLMReport {
    final static StringBuilder head = new StringBuilder();
    final static StringBuilder step = new StringBuilder();
    final static StringBuilder bottom = new StringBuilder();

    private static void head() {
        head.append("<!DOCTYPE html><html><body>");
        head.append("<table style=\"width:100%\">");
        head.append("<tr><th>Firstname</th><th>Lastname</th><th>Age</th></tr>");
    }

    private static void bottom() {
        step.append("</table></body><html>");
    }

    public static void write(Step step) {
        bottom.append(step);
    }

    private static void generate() {
    }
}
