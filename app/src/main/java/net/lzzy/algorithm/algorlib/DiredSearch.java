package net.lzzy.algorithm.algorlib;

import android.net.NetworkInfo;
import android.sax.StartElementListener;

import java.sql.ResultSetMetaData;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class DiredSearch <T extends  Comparable<? super  T>>extends  BaseSearch<T> {
    private T key;

    DiredSearch(T[] items) {
        super(items);
    }

    @Override
   public int search(T key) {
        this.key = key;
        long start=System.currentTimeMillis();
        int pos = 0;
        for (T item : items) {
            if (equal(item, key)) {
            setDuraation(System.currentTimeMillis()-start);
                return pos;
            }
            pos++;
        }
        setDuraation(System.currentTimeMillis()-start);
        return -1;
    }

}
