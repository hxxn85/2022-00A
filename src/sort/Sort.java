package sort;

import java.util.Comparator;

public abstract class Sort<T> {
    public abstract T[] sort(T[] src, Comparator<T> comp);
}
