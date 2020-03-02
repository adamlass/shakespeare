package sorting;

/**
 * SelectionSort
 */
public class SelectionSort<T extends Comparable> extends Sorter<T> {

    @Override
    public T[] sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }

            if (arr[min].compareTo(arr[i]) != 0) {
                swap(arr, i, min);
            }
        }
        return arr;
    }
}