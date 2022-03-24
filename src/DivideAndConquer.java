import java.util.Random;

public class DivideAndConquer {
    private boolean isNotDividable(int start, int end) {
        return start >= end;
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (isNotDividable(start, end)) return;

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int p = start;
        int q = mid + 1;
        int idx = p;

        int[] tmp = new int[arr.length];

        while(p <= mid || q <= end) {
            if (q > end || (p <= mid && arr[p] < arr[q])) tmp[idx++] = arr[p++];
            else tmp[idx++] = arr[q++];
        }

        if (end + 1 - start >= 0) System.arraycopy(tmp, start, arr, start, end + 1 - start);
    }

    private static void printArray(int[] arr) {
        for (int j : arr) System.out.printf("%d ", j);
        System.out.println();
    }

    private static int[] randomArray(int n) {
        Random r = new Random();
        return r.ints(n, 0, n*100).toArray();
    }

    public static void main(String[] args) {
        int nArray = 30;
        int[] arr = randomArray(nArray);
        printArray(arr);

        DivideAndConquer dac = new DivideAndConquer();
        dac.mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}
