package sort;

public class SortTestDrive {
    public static void main(String[] args) {
        Float[] arr = {7.3f, 8.2f, 6.4f, 5.1f, 4.4f, 3.3f, 2.2f, 1.1f};
//        Integer[] arr = {7, 8, 6, 5, 4, 3, 2, 1};

        Sort<Float> sort = new SelectionSort();
//        Integer[] res = sort.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1 > o2) return 1;
//                if(o1 < o2) return -1;
//                return 0;
//            }
//        });

        Float[] res = sort.sort(arr, (x, y) -> {
            if (x > y) return 1;
            if (x < y) return -1;
            return 0;
        });

        for (int i = 0; i < res.length; i++) {
            System.out.printf("%.1f ", res[i]);
        }
    }
}
