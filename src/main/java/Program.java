import java.util.regex.Pattern;

public class Program {
    private static String path;

    public static int main( String [] arguments ) {
        try {
            argumentParser(arguments);
        } catch (Exception e) {
            System.out.print("Unable to parse commands.");
            e.printStackTrace();
            help();
        }

        return 0;
    }

    private static void help() {
        System.out.println("Command line arguments: ");
        System.out.println("    --file: 'File path to run single test, file extension: *.test.json '");
        System.out.println("    --directory: 'Directory path to run all tests, file extension: *.test.json '");
    }

    private static String extractPath(String argument) {
        Pattern pattern = Pattern.compile("['|\"](.*?)['|\"]");
        return pattern.matcher(argument).group(1);
    }

    private static void argumentParser(String [] arguments) {
        if(arguments != null && arguments.length > 0) {
            for (String argument : arguments) {
                if(argument.contains("--directory") || argument.contains("--file")) {
                    path = extractPath(argument);
                }
            }
        }
    }
}
