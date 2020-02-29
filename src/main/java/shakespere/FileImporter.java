package shakespere;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileImporter {
    public static String[] toStringArray(String filepath, String delimiter) throws IOException {
        return Files.lines(Paths.get(filepath))
        .flatMap(line -> Stream.of(line.split(delimiter)))
        .filter(seq -> !seq.isEmpty())
        .map(seq -> seq.toLowerCase())
        .toArray(String[]::new);
    }
}