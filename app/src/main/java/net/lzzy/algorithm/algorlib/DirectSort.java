package net.lzzy.algorithm.algorlib;

import android.provider.Settings;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.util.AndroidException;

import java.util.zip.ZipEntry;

/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:
 */
public class DirectSort<T extends  Comparable<? super  T>>extends  BaseSort {
    DirectSort(T[] items) {
        super(items);
    }
    //field字段：



    @Override
    public void sort() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < items.length; i++) {
            int j = i - 1;
            if (bigger(items[i], items[j])) {
                continue;
            }
            T tmp = (T) items[i];
            while (j >= 0 && bigger(items[j], tmp)) {
                items[j + 1] = items[j];
                moveStep++;
                j--;
            }
        }

    }
}
