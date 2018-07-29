package schema;

import Report.HTLMReport;

import java.io.IOException;
import java.util.regex.Pattern;

public class Program {
    private static String path;

    public static int main( String [] arguments ) throws IOException {
        try {
            //argumentParser(arguments);
            path = arguments[0];
        } catch (Exception e) {
            System.out.print("Unable to parse commands.");
            e.printStackTrace();
            help();
            return 1;
        }

        try {
            JsonRunner runner = new JsonRunner(path);
            runner.runSteps();
        } catch (Exception e) {
            System.out.print("Unable to run steps.");
            e.printStackTrace();
            return 1;
        } finally {
            HTLMReport.generate();
        }

        return 0;
    }

    private static void help() {
        System.out.println("Command line arguments: ");
        System.out.println("    --file: 'File path to run single test, file extension: *.test.json '");
    }

    private static String extractPath(String argument) {
        Pattern pattern = Pattern.compile("['|\"](?<Path>.*?)['|\"$]");
        return pattern.matcher(argument).group("Path");
    }

    private static void argumentParser(String [] arguments) {
        if(arguments != null && arguments.length > 0) {
            for (String argument : arguments) {
                if(argument.contains("--file")) {
                    path = extractPath(argument);
                }
            }
        }
    }
}