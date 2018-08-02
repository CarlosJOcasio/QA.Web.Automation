package console;

import report.HTLMReport;
import org.apache.maven.shared.utils.io.FileUtils;
import report.Step;
import schema.JsonRunner;
import utility.FileSystem;
import utility.Property;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.*;

public class Program {
    private final static String cmdParserRegEx = Property.getProperty("./configuration/selenium.properties","schema.program.command.line.parser.regex");
    private static String browsers = Property.getProperty("./configuration/selenium.properties", "default.browser");
    private static String options = Property.getProperty("./configuration/selenium.properties", "default.options");
    private static String path = "";

    public static int main( String[] arguments ) throws IOException {
        try {
            if(Arrays.stream(arguments).anyMatch(a -> a.equalsIgnoreCase("-help"))) {
                help();
                return 0;
            }

            Arrays.stream(arguments).forEach(s -> { setArgument(s); });

            inspectPath();

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
<<<<<<< HEAD:src/main/java/schema/Program.java
        System.out.println("Command line arguments: ");
        System.out.println("\t\t-file: 'File path to run single test, file extension: *.test.json'");
        System.out.println("\t\t-browsers: 'Browsers to test. Accepted values:chrome,firefox,edge,chrome,android,iphone'. Default to chrome.");
        System.out.println("\t\t-options: 'Application options. Accepted values:fastLoad,headless,normal'. Default to fastLoad");
=======
        Objects.requireNonNull(FileSystem.getFileListFromResources("./cmd/help")).forEach(l -> {
            System.out.println(l);
        });
>>>>>>> 53f0ff8dacb3302686b3a21e4690f6decbe894c8:src/main/java/console/Program.java
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

        if(argument.contains("-options:")) {
            options = extractFilePath(argument);
        }

        if(argument.contains("-report:")) {
            HTLMReport.reports = extractFilePath(argument);
        }
    }

    private static void inspectPath() {
        if(path == null || path.isEmpty() || !FileUtils.fileExists(path) || !path.endsWith(".test.json")) {
            HTLMReport.write(new Step("Invalid Json Test File provided.", "File path command line argument.", path));
        }
    }
}