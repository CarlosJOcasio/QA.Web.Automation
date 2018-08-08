package console;

import report.HTLMReport;
import org.apache.maven.shared.utils.io.FileUtils;
import report.Step;
import schema.JsonRunner;
import utility.FileSystem;
import utility.Property;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.*;

public class Program {
    private final static String cmdParserRegEx = Property.getProperty("./configuration/selenium.properties","schema.program.command.line.parser.regex");
    private static String browsers = Property.getProperty("./configuration/selenium.properties", "default.browser");
    private static String options = Property.getProperty("./configuration/selenium.properties", "default.options");
    private static String path = "";
    private final static  List<File> paths = new ArrayList(){};

    public static int main( String[] arguments ) throws IOException {
        try {
            if(arguments.length == 0 || Arrays.stream(arguments).anyMatch(a -> a.equalsIgnoreCase("-help"))) {
                help();
                return 0;
            }

            Arrays.stream(arguments).forEach(s -> { setArgument(s); });

            if(paths.size() > 0) {
                paths.forEach( p -> {
                    path = p.getPath();
                    runner();
                });

            } else {
                runner();
            }

        } catch (Exception e) {
            HTLMReport.write(new Step("Unable to run steps.", e.getMessage()));
            return 1;
        } finally {
            HTLMReport.generate();
        }

        return 0;
    }

    private static void runner() {
        inspectPath();

        JsonRunner runner = new JsonRunner(path, browsers, options);
        runner.start();
        runner.runBrowser();
        runner.end();

    }

    private static void help() {
        Objects.requireNonNull(FileSystem.getFileListFromResources("./cmd/help")).forEach(l -> {
            System.out.println(l);
        });
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

        if(argument.contains("-report:")) {
            HTLMReport.reports = extractFilePath(argument);
        }

        if(argument.contains("-browsers:")) {
            browsers = extractFilePath(argument);
        }

        if(argument.contains("-options:")) {
            options = extractFilePath(argument);
        }

        if(argument.contains("-directory:")) {
            path = extractFilePath(argument);
            paths.addAll( FileSystem.getFiles(path, ".test.json") );
        }
    }

    private static void inspectPath() {
        if(path == null || path.isEmpty() || !FileUtils.fileExists(path) || !path.endsWith(".test.json")) {
            HTLMReport.write(new Step("Invalid Json Test File provided.", "File path command line argument.", path));
        }
    }
}