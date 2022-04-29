package sort;

import java.util.Comparator;

public class SelectionSort<T> extends Sort<T>{
    @Override
    public T[] sort(T[] src, Comparator<T> comp) {
        System.out.println(this.getClass().getSimpleName());
        T[] dst = src.clone();

        for (int i = 0; i < dst.length; i++) {
            T min = dst[i];
            int idx = i;

            // 최솟값 (인덱스)
            for (int j = i; j < dst.length; j++) {
                if(comp.compare(min, dst[j]) > 0) {
                    min = dst[j];
                    idx = j;
                }
            }

            // 제일 왼쪽이랑 최솟값이랑 교환
            T tmp = dst[i];
            dst[i] = dst[idx];
            dst[idx] = tmp;
        }
        return dst;
    }
}
