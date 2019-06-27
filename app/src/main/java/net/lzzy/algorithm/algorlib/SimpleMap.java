package net.lzzy.algorithm.algorlib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public class SimpleMap {
    int vertexCount;
    List<Edge>edges=new ArrayList<>();

    public  SimpleMap(int v){
        vertexCount=v;
    }
    public void addEge(int source,int target,double distance){
        edges.add(new Edge(source , target , distance));
    }
    class Edge{
        private int source;
        private  int targe;
        private double distance;

    }
}
