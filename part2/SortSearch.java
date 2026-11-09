import java.util.Arrays;

public class SortSearch {

    // 1. Merge Sort (rekursif)
    public static void mergeSort(int[] a) {
        if (a.length <= 1) return;               // base case
        int mid = a.length / 2;
        int[] left  = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);
        mergeSort(left);
        mergeSort(right);
        merge(a, left, right);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) result[k++] = left[i++];
            else                     result[k++] = right[j++];
        }
        while (i < left.length)  result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
    }

    // 2. Reverse: ascending -> descending (in-place)
    public static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int tmp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = tmp;
        }
    }

    // 3. Linear Search rekursif
    public static int linearSearch(int[] a, int target) {
        return linearSearch(a, target, 0);
    }

    private static int linearSearch(int[] a, int target, int index) {
        if (index >= a.length) return -1;         // tidak ditemukan
        if (a[index] == target) return index;     // ditemukan
        return linearSearch(a, target, index + 1);
    }

    // 4. Binary Search rekursif (array harus terurut ascending)
    public static int binarySearch(int[] a, int target) {
        return binarySearch(a, target, 0, a.length - 1);
    }

    private static int binarySearch(int[] a, int target, int low, int high) {
        if (low > high) return -1;                // tidak ditemukan
        int mid = low + (high - low) / 2;
        if (a[mid] == target) return mid;
        if (a[mid] < target)  return binarySearch(a, target, mid + 1, high);
        return binarySearch(a, target, low, mid - 1);
    }

    // Contoh pengujian
    public static void main(String[] args) {
        int[] b = {17, 2, 3, 8, 5, 11, 1};
        mergeSort(b);
        System.out.println(Arrays.toString(b));   // [1, 2, 3, 5, 8, 11, 17]
        System.out.println(binarySearch(b, 11));  // 5
        System.out.println(linearSearch(b, 100)); // -1
        reverse(b);
        System.out.println(Arrays.toString(b));   // [17, 11, 8, 5, 3, 2, 1]
    }
}