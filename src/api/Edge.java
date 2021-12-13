package api;

import java.util.HashMap;
import java.util.Map;

public class Edge implements EdgeData {

    private int src, dest;
    private double weight;
    private int tag;
    private String info;


    public Edge(int s, double w, int d) {

        this.src = s;
        this.dest = d;
        this.weight = w;

    }



    public Edge copy() {
        return new Edge(this.src,this.weight,this.dest);

    }

    public Edge(int src, int dest, double weight, int tag, String info) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
        this.tag = tag;
        this.info = info;
    }


    @Override
    public int getSrc() {
        return this.src;
    }

    @Override
    public int getDest() {
        return this.dest;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;

    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {

        this.tag = t;
    }
}
