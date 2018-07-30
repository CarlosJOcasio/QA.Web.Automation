package report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class HTLMReport {
    private final static StringBuffer head = new StringBuffer();
    private final static StringBuffer body = new StringBuffer();
    private final static StringBuffer bottom = new StringBuffer();

    private static void head() {
        head.append("<!DOCTYPE html><html><body>");
        head.append("<!DOCTYPE html>");
        head.append("<html lang=\"en\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        head.append("<title>Selenium Report</title>");
        head.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        head.append("<link rel=\"icon\" type=\"image/png\" href=\"file:///C:/Users/CarlosJ/Downloads/Table_Fixed_Header/Table_Fixed_Header/images/icons/favicon.ico\">");
        head.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"./Selenium Report_files/bootstrap.min.css\">");
        head.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"./Selenium Report_files/font-awesome.min.css\">");
        head.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"./Selenium Report_files/animate.css\">");
        head.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"./Selenium Report_files/select2.min.css\">");
        head.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"./Selenium Report_files/perfect-scrollbar.css\">");
        head.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"./Selenium Report_files/util.css\">");
        head.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"./Selenium Report_files/main.css\">");
        head.append("</head>");
        head.append("<body>");
        head.append("<div class=\"limiter\">");
        head.append("<div class=\"container-table100\">");
        head.append("<div class=\"wrap-table100\">");
        head.append("<div class=\"table100 ver3 m-b-110\">");
        head.append("<div class=\"table100-head\">");
        head.append("<table>");
        head.append("<thead>");
        head.append("<tr class=\"row100 head\">");
        head.append("<th class=\"cell100 column1\">DESCRIPTION</th>");
        head.append("<th class=\"cell100 column2\">NAME</th>");
        head.append("<th class=\"cell100 column3\">LOCATOR TYPE</th>");
        head.append("<th class=\"cell100 column4\">LOCATOR</th>");
        head.append("<th class=\"cell100 column5\">VALUE</th>");
        head.append("<th class=\"cell100 column6\">STATUS</th>");
        head.append("</tr>");
        head.append("</thead>");
        head.append("</table>");
        head.append("</div>");
        head.append("<div class=\"table100-body js-pscroll ps ps--active-y\">");
        head.append("<table>");
        head.append("<tbody>");
    }

    private static void bottom() {
        bottom.append("</tbody>");
        bottom.append("</table>");
        bottom.append("<div class=\"ps__rail-x\" style=\"left: 0px; bottom: 0px;\"><div class=\"ps__thumb-x\" tabindex=\"0\" style=\"left: 0px; width: 0px;\"></div></div><div class=\"ps__rail-y\" style=\"top: 0px; height: 585px; right: 5px;\"><div class=\"ps__thumb-y\" tabindex=\"0\" style=\"top: 0px; height: 293px;\"></div></div></div>");
        bottom.append("</div>");
        bottom.append("</div>");
        bottom.append("</div>");
        bottom.append("</div>");
        bottom.append("<script src=\"./Selenium Report_files/jquery-3.2.1.min.js.download\"></script>");
        bottom.append("<script src=\"./Selenium Report_files/popper.js.download\"></script>");
        bottom.append("<script src=\"./Selenium Report_files/bootstrap.min.js.download\"></script>");
        bottom.append("<script src=\"./Selenium Report_files/select2.min.js.download\"></script>");
        bottom.append("<script src=\"./Selenium Report_files/perfect-scrollbar.min.js.download\"></script>");
        bottom.append("<script>");
        bottom.append("$('.js-pscroll').each(function(){");
        bottom.append("var ps = new PerfectScrollbar(this);");
        bottom.append("$(window).on('resize', function(){");
        bottom.append("ps.update();");
        bottom.append("})");
        bottom.append("});");
        bottom.append("</script>");
        bottom.append("<script src=\"./Selenium Report_files/main.js.download\"></script>");
        bottom.append("</body></html>");
    }

    public static void write(Step step) {
        body.append(step.toString());
    }

    public static void generate() throws IOException {
        head();
        bottom();

        File file = new File("./Reports/report.html");
        Files.deleteIfExists(file.toPath());
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(head.append(body).append(bottom).toString());
        writer.flush();
        writer.close();
    }
}