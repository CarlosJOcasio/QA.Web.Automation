package report;

import utility.FileSystem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class HTLMReport {
    private final static StringBuffer head = new StringBuffer();
    private final static StringBuffer body = new StringBuffer();
    private final static StringBuffer end = new StringBuffer();

    private static void head() {
        List<String> list = FileSystem.getFileList("./report/head");
        if(list!= null && list.size() > 0) {
            list.forEach(l -> head.append(l));
        }
    }

    private static void end() {
        List<String> list = FileSystem.getFileList("./report/end");
        if(list!= null && list.size() > 0) {
            list.forEach(l -> head.append(l));
        }
    }

    public static void write(Step step) {
        body.append(step.toString());
    }

    public static void generate() throws IOException {
        head();
        end();

        File file = new File("./Reports/report.html"); //todo move to a command line
        Files.deleteIfExists(file.toPath());
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(head.append(body).append(end).toString());
        writer.flush();
        writer.close();
    }
}