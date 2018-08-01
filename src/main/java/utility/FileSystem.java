package utility;

import org.apache.maven.shared.utils.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileSystem {

    public static List<String> getFileListFromResources(String path) {
        try {
            return Files.readAllLines(new File(ClassLoader.getSystemResource(path).getFile()).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void copyDirectory(String source, String destination) {
        try {
            FileUtils.copyDirectory(new File(source), new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean exists(String path) {
        return Files.exists(Paths.get(path));
    }
}