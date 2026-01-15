package org.cft;

public class Stats<T> {
    private int count;
    private T max;
    private T min;

    public Stats(int count, T max, T min) {
        this.count = count;
        this.max = max;
        this.min = min;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public T getMin() {
        return min;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        this.count++;
    }
}
