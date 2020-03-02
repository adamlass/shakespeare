package sorting;


/**
 * InsertionSort
 */
public class InsertionSort<T extends Comparable> extends Sorter<T> {

    @Override
    public T[] sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1].compareTo(arr[j]) > 0) {
                swap(arr, j, j - 1);
                j = j - 1;
            }
        }
        return arr;
    }

}