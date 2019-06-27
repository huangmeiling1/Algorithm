package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public abstract class BaseSearch  <T extends Comparable<? super T>> {
    T[] items;
    long duration;
    int compareCount;
    int swapCount;
    int moveStep;


    BaseSearch(T[]items){
        this.items=items;
        compareCount=0;
        swapCount=0;
        moveStep=0;
    }

    void  swap(int i, int j){
        T tmp=items[i];
        items[i]=items[j];
        items[j]=tmp;
        swapCount++;
    }

    boolean equal(T a,T b){
        compareCount++;
        return a.compareTo(b)==0;

    }
    int  compare(T a, T b){
        compareCount++;
        return a.compareTo(b);
    }
    public void setDuraation(long l) {
    }

    public int search(T key) {
        return 0;
    }

    public long getDuration() {
        return duration;
    }
    public void getDuration(long duration) {
        this.duration = duration;
    }

    public int getCompareCount() {
        return compareCount;
    }
    public void getCompareCount(int compareCount) {
        this.compareCount=compareCount;
    }
    public int getSwapCount() {
        return swapCount;
    }
    public void getSwapCount(int swapCount) {
        this .swapCount=swapCount;
    }
    public int getMoveStep() {
        return moveStep;
    }
    public void getMoveStep(int moveStep) {
        this.moveStep=moveStep;
    }
    BaseSearch(){}
}
