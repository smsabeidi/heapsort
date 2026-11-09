import java.util.Arrays;

public class HeapSort {

    // Move the value at index i down until the subtree is a max-heap.
    public static void heapify(int[] arr, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, size, largest);
        }
    }

    public static void heapSort(int[] arr) {
        // Build a max-heap from the bottom up.
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }

        // Put the largest value at the end, then fix the smaller heap.
        for (int end = arr.length - 1; end > 0; end--) {
            int temp = arr[0];
            arr[0] = arr[end];
            arr[end] = temp;
            heapify(arr, end, 0);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 22, 9, 76, 63, 81, 48, 92, 54, 28};
        System.out.println("Original: " + Arrays.toString(numbers));
        heapSort(numbers);
        System.out.println("Sorted:   " + Arrays.toString(numbers));
    }
}
