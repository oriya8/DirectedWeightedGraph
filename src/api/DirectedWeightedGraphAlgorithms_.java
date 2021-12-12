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



//
//    public Double shortttt (NodeData n, Iterator t, ArrayList<NodeData> route,NodeData des){
//        if(n.getKey()==des.getKey()){
//            // System.out.println("**");
//            return  ;
//        }
//        //  System.out.println("*");
//        while (t.hasNext()) {
//            EdgeData gk = (EdgeData)t.next();
//            int nod = gk.getDest();
//            NodeData is = g.getNode(nod);
//            if(route.contains(is)){
//                continue;
//            }
//            route.add(is);
//            Iterator a = this.g.edgeIter(nod);
//            rec(cities,is,a,good);
//            if(good.size()== cities.size()){
//                return good;}
//        }
//        if(good.contains(n)){
//            good.remove(n);
//        }
//        //   System.out.print(good);
//        return good;
//    }



















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
        HashMap <NodeData,Integer> change = new HashMap <NodeData,Integer>();
        HashMap <Integer,NodeData> change2 = new HashMap <>();
        Iterator<NodeData> t = g.nodeIter();
        int ind=0;
        while(t.hasNext()){
            NodeData tt = t.next();
            change.put(tt,ind);
            change2.put(ind,tt);
            ind++;
        }
        double inf = Double.MAX_VALUE;
        double [][] s = new double [g.nodeSize()][g.nodeSize()];
        for (int i=0;i<s.length;i++){
            for(int j=0;j<s.length;j++){
              if (i==j) {
                  s[i][j] = Double.valueOf(0);
              }
              else{
                  s[i][j]=inf;
              }
            }
        }
        Iterator<EdgeData> l= g.edgeIter();
        while(l.hasNext()){
            EdgeData egg = l.next();
            int src = egg.getSrc();
            int des= egg.getDest();
            NodeData na = g.getNode(src);
            NodeData da = g.getNode(des);
            s[change.get(na)][change.get(da)]=egg.getWeight();
        }

            for (int k = 0; k < s.length; k++) {
                for (int i = 0; i < s.length; i++) {
                    for (int j = 0; j < s.length; j++) {
                        if (s[i][k] == inf || s[k][j] == inf || j == k || i == j || i == k ) {
                            continue;
                        }
                        s[i][j] = Math.min(s[i][j],s[i][k]+s[k][j]);
                    }
                }
            }
        double [] result = new double[s.length];
        for (int i=0;i<s.length;i++){
            double max = 0;
        for(int j=0;j<s.length;j++){
            if(max < s[i][j]) {
                max= s[i][j];}
            }
            result[i]= max;
        }
        double ans =Double.MAX_VALUE;
        int indexnode = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[i] < ans) {
				ans = result[i];
                indexnode=i;
			}
		}
        return change2.get(indexnode);
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
