package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DirectedWeightedGraphAlgorithms_ implements DirectedWeightedGraphAlgorithms {
    private DirectedWeightedGraph g;

    public DirectedWeightedGraphAlgorithms_(DirectedWeightedGraph g) {
        this.g = g;
    }


    @Override
    public void init(DirectedWeightedGraph g) {
        this.g=g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.g;
    }

    @Override
    public DirectedWeightedGraph copy() {
      DirectedWeightedGraph p = new DirectedWeightedGraph_();
        Iterator <NodeData> i = g.nodeIter();
        while(i.hasNext()){
            NodeData noo = i.next();
            p.addNode(noo);
        }
        Iterator <EdgeData> ii = g.edgeIter();
        while(ii.hasNext()){
            EdgeData noo = ii.next();
            p.connect(noo.getSrc(), noo.getDest(), noo.getWeight());
        }
        return p;
    }

    @Override
    public boolean isConnected() {

        return false;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return null;
    }

    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        ArrayList<NodeData>anssss= new ArrayList<NodeData>();
        for (NodeData in :cities){
            Iterator re =g.edgeIter(in.getKey());
            anssss=rec(cities,in,re,anssss);
        }
        System.out.print("anssss"+"\n");
        System.out.print(anssss);
        return anssss;
    }

    public ArrayList<NodeData> rec (List<NodeData> cities,NodeData n, Iterator t, ArrayList<NodeData> good){
        if(good.size()==cities.size()){
            System.out.println("**");
            return good;
        }
        System.out.println("*");
        while (t.hasNext()) {
            EdgeData gk = (EdgeData)t.next();
            int nod = gk.getDest();
            NodeData is = g.getNode(nod);
            if (!cities.contains(is)){
                continue;
            }
            if(good.contains(is)){
                continue;
            }
            good.add(is);
            Iterator a = this.g.edgeIter(nod);
            rec(cities,is,a,good);
            if(good.size()== cities.size()){
                return good;}
        }
        if(good.contains(n)){
            good.remove(n);
        }
        System.out.print(good);
        return good;
    }
    @Override
    public boolean save(String file) {
        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
    }
}
