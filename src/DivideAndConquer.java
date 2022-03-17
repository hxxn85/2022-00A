
public class DivideAndConquer {
    private boolean isSomething(int start, int end) {
        return start >= end;
    }

    public int[] mergeSort(int[] arr, int start, int end) {
        if (isSomething(start, end)) {
            return null;
        }

        int mid = (start + end) / 2;

        mergeSort(arr, 0, mid);
        mergeSort(arr, mid+1, end);

        merge(arr, start, mid, end);

        return null;
    }

    private int[] merge(int[] arr, int start, int mid, int end) {
        int p = start;
        int q = mid + 1;
        int idx = p;

        int[] tmp = new int[arr.length];

        while(p <= mid || q <= end) {
            if (q > end || (p <= mid && arr[p] < arr[q])) {
                tmp[idx++] = arr[p++];
            } else {
                tmp[idx++] = arr[q++];
            }
        }

        for (int i=start; i<=end; i++) {
            arr[i] = tmp[i];
        }

        return null;
    }

    public static void main(String[] args) {
        int arr[] = {7, 6, 5, 4, 3, 2, 1, 0};
        for (int i=0; i<arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();

        DivideAndConquer dac = new DivideAndConquer();
        dac.mergeSort(arr, 0, arr.length-1);

        for (int i=0; i<arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}
