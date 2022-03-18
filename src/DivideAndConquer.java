public class DivideAndConquer {
    private boolean isSomething(int start, int end) {
        return start >= end;
    }

    // 재귀 함수
    // c: 배열명 = 주소
    // 자바: 배열명, 배열


    // primitive types: 원시변수: 값이 복사
    // 객체: 주소값
    public void mergeSort(int[] arr, int start, int end) {
        if (isSomething(start, end)) {
            return;
        }

        int mid = (start + end) / 2;    // 중간값

        // 후위 순회
        mergeSort(arr, 0, mid);     // 왼쪽 절반
        mergeSort(arr, mid+1, end); // 오른쪽 절반

        merge(arr, start, mid, end);      // 정복
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
