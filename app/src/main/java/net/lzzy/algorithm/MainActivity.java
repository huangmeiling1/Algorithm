package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.lzzy.algorithm.algorlib.BaseSearch;
import net.lzzy.algorithm.algorlib.BaseSort;
import net.lzzy.algorithm.algorlib.SearchFactory;
import net.lzzy.algorithm.algorlib.SortFactoy;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    int i, j;
    Spinner spinner;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
        final Spinner Search=findViewById(R.id.action_main_sp1);
        initSpinner();
        Button listener=findViewById(R.id.listener);
        listener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseSearch<Integer> search= SearchFactory.getInstance(Search.getSelectedItemPosition(),items);
                if (search!=null){
                    int pos=search.search(v.getId());

                    tvResult.setText("该元素位于数组的第".concat((pos+1)+"位"));
                }
            }
        });

    }
    private  void resetSearch(){
        container.removeAllViews();
        generateItems();
        if (spinner.getSelectedItemPosition()==1){

        }
//    btnSort.callOnClick();
        for (Integer i:items){
            Button btn=new Button(this);
            btn.setText(String.format(i.toString(), Locale.CHINA));
            btn.setId(i);
            btn.setLayoutParams(new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.WRAP_CONTENT,1));
            btn.setOnClickListener(listener);
            container.addView(btn);

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                BaseSort<Integer> sort=SortFactoy.getInstance(spinner.getSelectedItemPosition(),items);
                BaseSort<Integer>sortNotNull= Objects.requireNonNull(sort);
                sortNotNull.sortWinthTime();
                String result=sortNotNull.getResult();
                tvResult.setText(result);
                Toast.makeText(this, "总时长："+sort.getDuration(), Toast.LENGTH_SHORT).show();
               intsertSort();
                displayItems(tvResult);
                break;
            default:
                break;
        }
    }

    private void initSpinner(){
        spinner=findViewById(R.id.action_main_sp);
        spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, SortFactoy.getSortName()));

    }
    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {  //直接选择排序
        //todo:直接选择排序的具体实现
        //分为有序和无序区，每一趟排序都在无序区依次对比，记录对比区域的最小元素的位置。
        //然后把无序区第一个元素和所记录的最小元素进行交换，无序区少一个，有序区多一个，循环往复直至质无序区
        //元素数量为0
        for ( int i=0;i<items.length-1;i++) {
            int minpos=i;
            for (int j = i+1; j < items.length; j++) {
                if (items[minpos].compareTo(items[i])>0) {
                    minpos=i;
                }
            }
            swap(minpos,i);
        }

    }
    public   void intsertSort(){
//        for ( int i=1;i<items.length;i++){
//            if (items[i]<items[i-1]){
//                int temp=items[i];
//
//                int w=i-1;
//                for (int j=w;j>0&temp<items[j];j--){
//                    items [j+1]=items[j];
//                    w--;
//                }
//                items[w+1]=temp;
//            }
//        }
        for (int i = 1;i<items.length;i++){
            int j=i-1;
            if (items[j].compareTo(items[i])<0){
                continue;
            }
            Integer tmp=items[i];
            while (j>=0&&items[i].compareTo(tmp)>0){
                items[j+1]=items[j];
                i--;
                items[j+1]=tmp;
            }
        }
    }


    private void swap(int m, int n) {
        int tmp=items[m];
        items[m]=items[n];
        items[n]=tmp;
    }

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
