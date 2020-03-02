package shakespere;

import java.io.IOException;
import java.util.Arrays;

import sorting.*;

/**
 * Hello world!
 *
 */
public class Shakespeare {
    public static void main(String[] args) throws IOException {
        final int SLICE = 40000;

        Sorter[] sorting = { 
                new SelectionSort<>(),
                new InsertionSort<>(),
                new HeapSort<>(),
                new MergeSort<>(),
                new TrieSort()
        };

        System.out.println("\n==RUNNING SORTINGS OF SLICE " + SLICE + "==\n");
        
        for (Sorter sorter : sorting) {
            System.out.println("----------" + sorter.getClass().getSimpleName() + "----------");
            System.out.print("Duration in milis: ");
            String[] seqs = FileUtility.toStringArray("scw.txt", " ");
            seqs = Arrays.copyOfRange(seqs, 0, SLICE);

            try (Stopwatch sw = new Stopwatch()) {
                seqs = (String[]) sorter.sort(seqs);
                double stop = sw.step();
                System.out.printf("%5.6f\n", stop);
                
                double nanosUsed = stop / SLICE * 1_000_000;
                System.out.print("Nanos used per word: ");
                System.out.printf("%5.6f\n", nanosUsed);
            }

            boolean verified = seqs[0].equals("a") && seqs[SLICE - 1].equals("zealous");
            System.out.println("Verified: " + verified);
            System.out.println();

        }
    }

}
