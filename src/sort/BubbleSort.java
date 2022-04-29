package sort;

import java.util.Comparator;

public class BubbleSort<T> extends Sort<T>{
    public T[] sort(T[] src, Comparator<T> comp) {
        System.out.println(this.getClass().getSimpleName());
        T[] dst = src.clone();

        for (int i = 0; i < dst.length; i++) {
            for (int j = 0; j < dst.length - 1 - i; j++) {
                if(comp.compare(dst[j], dst[j+1]) > 0) {
                    T tmp = dst[j];
                    dst[j] = dst[j + 1];
                    dst[j + 1] = tmp;
                }
            }
        }

        return dst;
    }
}
