package api;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.*;

public class DirectedWeightedGraphAlgorithms_ implements DirectedWeightedGraphAlgorithms {
    private DirectedWeightedGraph_ g;

    public DirectedWeightedGraphAlgorithms_(DirectedWeightedGraph_ g) {
        this.g = g;

    }


    @Override
    public void init(DirectedWeightedGraph g) {
        this.g= (DirectedWeightedGraph_) g;
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

    private boolean checkLonely(){

        for (int i = 0; i < this.g.big.size(); i++) {

            if (this.g.big.get(i) == null){
                return true ;
            }
        }
        return false ;

    }

    @Override
    public boolean isConnected() {
        Iterator<NodeData> iter = this.g.nodeIter();
        while (iter.hasNext()) {
            NodeData ne = iter.next();
            ne.setTag(0);
        }
            if (this.g == null) {
                return true;
            }
            if (this.g != null && this.g.nodeSize() == 0) {
                return true;
            }
            if (this.g != null && this.g.nodeSize() == 1) {
                return true;
            }

            if (checkLonely()){
                return false ;
            }

            int counter = 0 ;
            Queue<NodeData> que = new LinkedList<>();
            que.add(this.g.nodeIter().next());
            NodeData n = que.peek();
            n.setTag(0);

            while (!que.isEmpty()) {
                n = que.poll();
                counter++;

                Iterator it = this.g.edgeIter(n.getKey());
                while (it.hasNext()) {
                    EdgeData edge = (Edge) it.next();
                    NodeData dest =  g.getNode(edge.getDest());
                    if (dest.getTag() == -1) {
                        if (!havePath(dest.getKey(), n.getKey())) {
                            return false;
                        }
                        dest.setTag(0);
                        que.add(dest);
                    }
                }
            }
            return g.all.size() == counter;
        }


        public boolean havePath(int src, int dest) {
            Stack<NodeData> st = new Stack<>();
            NodeData temp = g.getNode(src);
            HashSet<Integer> visited = new HashSet<>();
            visited.add(src);
            st.add(temp);
            while (!st.empty()) {
                temp = st.pop();
                Iterator tor = this.g.edgeIter(temp.getKey());
                while (tor.hasNext()) {
                    EdgeData cur = (Edge)tor.next();
                    NodeData next = g.getNode(cur.getDest());
                    if (!visited.contains(next.getKey())) {
                        visited.add(next.getKey());
                        st.add(next);
                    }
                    if (next.getKey() == dest)
                        return true;
                }
            }
            return false;
        }




    @Override
    public double shortestPathDist(int src, int dest) {
        int max = Integer.MAX_VALUE;
        Iterator<NodeData> iter = this.g.nodeIter();
        while (iter.hasNext()) {
            NodeData ne = iter.next();
            ne.setWeight(max);
            ne.setTag(0);
            ne.setInfo("-1");
        }
        NodeData from = g.getNode(src);
        from.setWeight(0);
        PriorityQueue<NodeData> tor = new PriorityQueue<NodeData>(new Comparator<NodeData>() {
            public int compare(NodeData one, NodeData two) {
                if(one.getWeight()<two.getWeight()) {
                    return 1;}
                else {
                    return -1;
                }
            }
        });
        tor.add(from);
        help(tor);
        NodeData destination= g.getNode(dest);
        if(destination.getWeight()==max){
            return -1;
        }
        System.out.println(destination.getInfo());
        System.out.println(g.getNode(2).getInfo());

        return destination.getWeight();
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        ArrayList<NodeData>anssss= new ArrayList<NodeData>();
        int max = Integer.MAX_VALUE;
        Iterator<NodeData> iter = this.g.nodeIter();
        while (iter.hasNext()) {
            NodeData ne = iter.next();
            ne.setWeight(max);
            ne.setTag(0);
            ne.setInfo("-1");
        }
        NodeData from = g.getNode(src);
        from.setWeight(0);
        PriorityQueue<NodeData> tor = new PriorityQueue<NodeData>(new Comparator<NodeData>() {
            public int compare(NodeData one, NodeData two) {
                if(one.getWeight()<two.getWeight()) {
                    return 1;}
                else {
                    return -1;
                }
            }
        });
        tor.add(from);
        help(tor);
        String info="";
        NodeData temp = g.getNode(dest);
        info = temp.getInfo();
        anssss.add(temp);
        while (temp!=from){
            temp =  g.getNode(Integer.valueOf(info));
            anssss.add(temp);
            info= temp.getInfo();
        }
        ArrayList<NodeData> revArrayList = new ArrayList<NodeData>();
        for (int i = anssss.size() - 1; i >= 0; i--) {
            revArrayList.add(anssss.get(i));
        }
        return revArrayList;
    }



    private void help(PriorityQueue tor){
        while(!tor.isEmpty()){
            NodeData pull = (NodeData) tor.poll();
            Iterator<EdgeData> over = g.edgeIter(pull.getKey());
            while (over.hasNext()){
                EdgeData edge = over.next();
                NodeData end = g.getNode(edge.getDest());
                double w=edge.getWeight()+pull.getWeight();
                if(pull.getTag()!=1 && w<end.getWeight()){
                    end.setWeight(w);
                    end.setInfo(String.valueOf(pull.getKey()));
                    tor.add(end);
                }
            }
            pull.setTag(1);
        }
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
            System.out.println(anssss);
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
            NodeData is = this.g.getNode(nod);
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
        try {
            Gson gson = new Gson();
            Writer fw = new FileWriter(file, false);
            JsonWriter jawr = gson.newJsonWriter(fw);
            jawr.beginObject();
            Iterator<NodeData> st = this.g.nodeIter();
            jawr.name("Nodes").beginArray();
            while (st.hasNext()) {
                Node temp = (Node) st.next();
                System.out.println(temp.toString());
                double x =  temp.getLocation().x();
                double y =  temp.getLocation().y();
               double z =  temp.getLocation().z();
                jawr.beginObject().name("pos").value(x + "," + y + "," + z);
                jawr.name("id").value(temp.getKey());
                jawr.endObject();
            }
            jawr.endArray().flush();
            jawr.name("Edges").beginArray();
            Iterator<EdgeData> la = g.edgeIter();
            while (la.hasNext()) {
                EdgeData di = la.next();
                int src = di.getSrc();
                int dest = di.getDest();
                double w = di.getWeight();
                jawr.beginObject().name("src").value(src);
                jawr.name("w").value(w);
                jawr.name("dest").value(dest);
                jawr.endObject();
            }
            jawr.endArray().endObject().flush();
            jawr.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean load(String file) {
        try {
            this.g = new DirectedWeightedGraph_(file);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        return false;
    }


}
