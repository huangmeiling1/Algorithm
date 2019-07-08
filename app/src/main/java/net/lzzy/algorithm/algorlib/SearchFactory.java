package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class SearchFactory  {

    public static <T extends Comparable<? super T> > BaseSort<T> getInstance(int key, T[] items){
        BaseSort<T>search;
        switch (key){
            case  0:
               search =  new DirectSort<>(items);
                break;
            case 1:
                search=new
                break;
            default:
                return null;

        }
        return search;
    }
    public  static String [] getSortName(){
        return new String[]{"顺序查找","二分查找","二分叉查找"};
    }
}
