package report;

import utility.FileSystem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HTLMReport {
    public static String reports = "./Reports";

    private final static StringBuffer head = new StringBuffer();
    private static void head() {
        List<String> list = FileSystem.getFileListFromResources("./report/head");
        if(list!= null && list.size() > 0) {
            list.forEach(l -> head.append(l));
        }
    }

    private final static StringBuffer end = new StringBuffer();
    private static void end() {
        List<String> list = FileSystem.getFileListFromResources("./report/end");
        if(list!= null && list.size() > 0) {
            list.forEach(l -> end.append(l));
        }
    }

    private final static StringBuffer body = new StringBuffer();
    public static void write(Step step) {
        body.append(step.toString());
    }

    public static void generate() throws IOException {
        head();
        end();

        String destination = String.format("%sSeleniumReport_files", reports);
        if(!FileSystem.exists(destination)) {
            FileSystem.copyDirectory("./Reports/SeleniumReport_files", destination);
        }

        final File file = new File(String.format("%s/report_%s.html", reports, new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())));
        final BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(head.append(body).append(end).toString());
        writer.flush();
        writer.close();
    }
}