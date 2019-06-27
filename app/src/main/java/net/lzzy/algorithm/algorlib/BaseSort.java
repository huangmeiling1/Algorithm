package net.lzzy.algorithm.algorlib;

import java.util.GregorianCalendar;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:  类型参数T需要加约束，约束T实现Comparble<T></>
 */
public  abstract class BaseSort<T extends Comparable<? super T>> {
    public T search;
    T[] items;
     long duration;
      int compareCount;
    int swapCount;
      int moveStep;
    BaseSort(T[]items){
        this.items=items;
        compareCount=0;
        swapCount=0;
        moveStep=0;
    }
    boolean bigger(T a,T b){
        compareCount++;
        return a.compareTo(b)>0;
    }
    void  swap(int i, int j){
        T tmp=items[i];
        items[i]=items[j];
        items[j]=tmp;
        swapCount++;
    }

    public String getResult(){
        String display = "";
        for (T i : items) {
            display = display.concat(i + ",");
        }
        return display.substring(0, display.length() - 1);

    }
    public void sortWinthTime(){
        long start=System.currentTimeMillis();
        sort();
        duration=System.currentTimeMillis()-start;

    }
    private int cocat(int i) {
        return 0;
    }

    public abstract void sort();
    public long getDuration() {
        return duration;
    }
    public int getCompareCount() {
        return compareCount;
    }
    public int getSwapCount() {
        return swapCount;
    }
    public int getMoveStep() {
        return moveStep;
    }

}
