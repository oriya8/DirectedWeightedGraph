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
        ArrayList<NodeData>anssss= new ArrayList<NodeData>();
        Iterator<NodeData> r = g.nodeIter();
        while (r.hasNext()){
            NodeData in = r.next();
            Iterator re =g.edgeIter(in.getKey());
            NodeData a =isconnrec(in,re,anssss);
            System.out.print("\n"+a);

        }
        return true;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return null;
    }



    public NodeData isconnrec (NodeData n, Iterator t, ArrayList<NodeData> good){
        if(good.size()==g.nodeSize()){
            System.out.print("\n"+"n:"+n);
            return n;
        }
        while (t.hasNext()) {
            EdgeData gk = (EdgeData)t.next();
            int nod = gk.getDest();
            NodeData is = g.getNode(nod);
            if(good.contains(is)){
                continue;
            }
            good.add(is);
            Iterator a = this.g.edgeIter(nod);
            isconnrec(is,a,good);
            if(good.size()==g.nodeSize()){
                return n;}
        }
        return n;
    }
    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        ArrayList<NodeData>anssss= new ArrayList<NodeData>();
        ArrayList<NodeData>fin= new ArrayList<NodeData>();

        double min=Double.MAX_VALUE;
        double isit =0;
        for (NodeData in :cities){
            Iterator re =g.edgeIter(in.getKey());
            anssss.clear();
            anssss=rec(cities,in,re,anssss);
            isit=minweight(anssss);
            if(isit<min){
                min=isit;
                fin.clear();
                fin.addAll(anssss);
            }
        }
        return fin;
    }



    public double minweight (ArrayList<NodeData> ansss){
      //  NodeData [] a = new NodeData[anss]
        double sum=0;
        for (int i=0;i<ansss.size()-1;i++){
           EdgeData v= this.g.getEdge( ansss.get(i).getKey(),ansss.get(i+1).getKey());
         sum+=v.getWeight();
        }
        return sum;



    }

    public ArrayList<NodeData> rec (List<NodeData> cities,NodeData n, Iterator t, ArrayList<NodeData> good){
        if(good.size()==cities.size()){
           // System.out.println("**");
            return good;
        }
      //  System.out.println("*");
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
     //   System.out.print(good);
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
