package api;

import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class DirectedWeightedGraph_ implements DirectedWeightedGraph {
  // static List<Edge> Edges = new ArrayList<>();
//   static List<Node> Nodeslist = new ArrayList<>();
   // Node [] answer;
  HashMap <Integer,Node> all = new HashMap <Integer, Node>();
  int numofedges = 0;

boolean nodes=false;
boolean edges = false;

    public DirectedWeightedGraph_(String path) throws FileNotFoundException {
        File input = new File(path);
        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileoObject = fileElement.getAsJsonObject();
        //fileoObject.

        List<Edge> Edges = new ArrayList<>();
        List<Node> Nodeslist = new ArrayList<>();
        JsonArray arrOfNodes = fileoObject.get("Nodes").getAsJsonArray();
        //List<Node> Nodeslist = new ArrayList<>();
        for (JsonElement i : arrOfNodes) {
            JsonObject nd = i.getAsJsonObject();
            String l = nd.get("pos").getAsString();
            System.out.println(l);
            String[] NZ;
            NZ = l.split(",");
            double a = Double.parseDouble(NZ[0]);
            double b = Double.parseDouble(NZ[1]);
            double c = Double.parseDouble(NZ[2]);
            GeoLocation_ pos = new GeoLocation_(a, b, c);
            int id = nd.get("id").getAsInt();
            Node node = new Node(pos, id);
            Nodeslist.add(node);

        }
      //  Map<Integer,Edge> conedges = new HashMap<Integer, Edge>();
      //  Map <Integer,HashMap> all = new HashMap <Integer, HashMap>();
//
//        Node [] answer = new Node[Nodeslist.size()];
//        for(Node r : Nodeslist){
//            int id = r.getKey();
//            answer[id]=r;
//        }


        JsonArray arrOfEdges = fileoObject.get("Edges").getAsJsonArray();
        // List<Edge> Edges = new ArrayList<>();
        for (JsonElement i : arrOfEdges) {
            JsonObject ed = i.getAsJsonObject();
            int src = ed.get("src").getAsInt();
            double w = ed.get("w").getAsDouble();
            int dest = ed.get("dest").getAsInt();
            Edge e = new Edge(src, w, dest);
            Edges.add(e);
            //conedges.put(dest,e);
           // all.put(src,);
            for (Node s : Nodeslist){
                s.conedges.put(dest,e);
            }
            //Nodeslist.conedges
            System.out.println(e.getInfo());
            System.out.println(" ");

        }
        numofedges=Edges.size();
        //HashMap <Integer,Node> all = new HashMap <Integer, Node>();
        for (Node d : Nodeslist) {
            this.all.put(d.getKey(),d);
        }

        for (Node n : Nodeslist) {
            n.getInfo();
            System.out.println(n.getInfo());
        }
    }

//    public Node [] bobbuilder (){
//
//
//
//        for(Edge ed : this.Edges){
//           int loca = ed.getSrc();
//           answer[loca].connectededges.add(ed);
//        }
//
//
//
//        return answer;
//    }



    @Override
    public NodeData getNode(int key) {
        return all.get(key);
//        for (Node n : this.Nodeslist) {
//            if(n.getKey()==key){
//                return n;
//            }
//        }
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        return all.get(src).conedges.get(dest);
//        for (Edge e : Edges) {
//            if( e.getSrc()==src && e.getDest()==dest){
//                return e;
//            }
//        }
        //return null;
    }

    @Override
    public void addNode(NodeData n) {

        Node adding = new Node(n.getLocation(),n.getKey());
        all.put(n.getKey(), adding);
 //   Nodeslist.add(adding);
    this.nodes=true;
    }

    @Override
    public void connect(int src, int dest, double w) {
    Edge adding = new Edge(src,w,dest);
    all.get(src).conedges.put(dest,adding);
    numofedges++;
   // Edges.add(adding);
    this.edges= true;
    }

    @Override
    public Iterator<NodeData> nodeIter() {
//    try {
////        List<NodeData> nodedata = new ArrayList<>();
////        for (Node n : this.Nodeslist) {
////            Node adding = new Node(n.getLocation(), n.getKey());
////            nodedata.add(adding);
        if(edges == true || nodes == true){
            throw new RuntimeException();}
         Iterator it = all.values().iterator();
        return it;
    }


    @Override
    public Iterator<EdgeData> edgeIter() {
        if(edges == true){
            throw new RuntimeException();}
        Set entrySet = all.entrySet();
        Iterator fin = null;
        Iterator it = entrySet.iterator();

        System.out.println("HashMap Key-Value Pairs : ");
        while(it.hasNext()){
            Node me = (Node)it.next();
            fin = me.conedges.values().iterator();
       }

        return fin;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        if(edges == true || nodes == true){
            throw new RuntimeException();}
        Iterator it = all.get(node_id).conedges.values().iterator();

        // for (Node n : Nodeslist) {
        //    if(n.getKey()==node_id){
        //        Iterator it = n.conedges.values().iterator();
                        //.connectededges.iterator();
        return it ;

    }

    @Override
    public NodeData removeNode(int key) {
        nodes=true;
        Node ans = all.get(key);
        all.remove(key);
//        for (Node n : this.Nodeslist) {
//            if(n.getKey()==key){
//                Nodeslist.remove(n);
//                ans=n;
//            }
//        }
        return ans;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        edges=true;
       Edge r = all.get(src).conedges.get(dest);
        numofedges--;
        all.get(src).conedges.remove(dest);
        return r;
    }

    @Override
    public int nodeSize() {
        return all.size();
    }

    @Override
    public int edgeSize() {
        int ans =0;
        Iterator t =all.values().iterator();
        while(t.hasNext()){
            Node me = (Node)t.next();
            ans+=me.s;
        }
return ans;
    }

    @Override
    public int getMC() {
        return 0;
    }

}
