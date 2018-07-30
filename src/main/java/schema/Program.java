package schema;

import report.HTLMReport;
import org.apache.maven.shared.utils.io.FileUtils;
import report.Step;
import utility.Property;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.*;

public class Program {
    private final static String cmdParserRegEx = Property.getProperty("./configuration/selenium.properties","schema.program.command.line.parser.regex");
    private static String path = "";
    private static String browsers = "chrome";
    private static String options = "fastLoad";

    public static int main( String [] arguments ) throws IOException {
        try {
            Arrays.stream(arguments).forEach(s -> { setArgument(s); });

            JsonRunner runner = new JsonRunner(path, browsers, options);
            runner.start();
            runner.runBrowser();
            runner.end();
        } catch (Exception e) {
            HTLMReport.write(new Step("Unable to run steps.", e.getMessage()));
            return 1;
        } finally {
            HTLMReport.generate();
        }

        return 0;
    }

    private static void help() {
        System.out.println("Command line arguments: ");
        System.out.println("    -file: 'File path to run single test, file extension: *.test.json'");
        System.out.println("    -browsers: 'Browsers to test. Accepted values:chrome,firefox,edge,chrome,android,iphone'. Default to chrome.");
        System.out.println("    -options: 'Application options. Accepted values:fastLoad,headless,normal'. Default to fastLoad");
    }

    private static String extractFilePath(String argument) {
        Pattern pattern = Pattern.compile(cmdParserRegEx);
        Matcher matcher = pattern.matcher(argument);
        return matcher.find() ? matcher.group("value") : null;
    }
    private static void setArgument(String argument) {
        if(argument.contains("-file:")) {
            path = extractFilePath(argument);
        }

        if(argument.contains("-browsers:")) {
            browsers = extractFilePath(argument);
        }

        if(argument.contains("-browserOptions:")) {
            options = extractFilePath(argument);
        }

        if(path == null || path.isEmpty() || !FileUtils.fileExists(path) || !path.endsWith(".test.json")) {
            HTLMReport.write(new Step("Invalid Json Test File provided.", "File path command line argument.", path));
        }
    }
}