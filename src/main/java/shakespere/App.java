package shakespere;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        String[] seqs = FileImporter.toStringArray("scw.txt", " ");
        System.out.println("Imported successfully!");
        System.out.println(seqs[1]);
    }
}
