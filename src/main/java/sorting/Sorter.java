
package sorting;

/**
 * ISort
 */
public abstract class Sorter<T> {
    public abstract T[] sort(T[] list);
    
    protected void swap(T[] arr, int i, int min) {
        T swapVar = arr[i];
        arr[i] = arr[min];
        arr[min] = swapVar;
    }
}