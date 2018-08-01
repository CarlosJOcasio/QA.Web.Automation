package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileSystem {

    public static List<String> getFileList(String path) {
        try {
            return Files.readAllLines(new File(path).toPath());
        } catch (IOException ignore) { }

        return null;
    }
}
