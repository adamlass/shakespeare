package sorting;

import java.lang.reflect.Array;

import shakespere.*;

/**
 * MergeSort
 */
public class MergeSort<T extends Comparable> extends Sorter<T> {

    @Override
    public T[] sort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;

            mergeSort(arr, left, m);
            mergeSort(arr, m + 1, right);
            merge(arr, left, m, right);
        }
    }

    private void merge(T[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        T[] leftArr = (T[]) Array.newInstance(arr[0].getClass(), n1);
        T[] rightArr = (T[]) Array.newInstance(arr[0].getClass(), n2);

        for (int i = 0; i < n1; ++i){
            leftArr[i] = arr[l + i];
        }

        for (int j = 0; j < n2; ++j){
            rightArr[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

}