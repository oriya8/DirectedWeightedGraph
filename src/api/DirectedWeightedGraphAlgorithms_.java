package api;

import java.util.ArrayList;
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
        DirectedWeightedGraph newone = copy();
        newone.nodeIter().remove();
        newone.addNode((NodeData) cities.iterator());
        ArrayList<NodeData>anssss= new ArrayList<NodeData>();

        for(int i=0;i<cities.size();i++){
            Iterator re =newone.edgeIter(i);
            Iterator c = cities.iterator();
            anssss=rec(newone,cities,(NodeData) c.next(),re,anssss);
            ;;}
        System.out.print(anssss);
        return null;
    }

    public ArrayList<NodeData> rec (DirectedWeightedGraph newone,List<NodeData> cities,NodeData n, Iterator t, ArrayList<NodeData> good){
        if(good.size()==cities.size()){
            return good;
        }
        System.out.println("**");
        System.out.println("*");

        while (t.hasNext()) {
            EdgeData g = (EdgeData)t.next();
            int nod = g.getDest();
            NodeData check = cities.get(nod);
            if(good.contains(check)){
                continue;
            }
            good.add(check);
            Iterator a = newone.edgeIter(nod);

            rec(newone,cities,check,a,good);
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
