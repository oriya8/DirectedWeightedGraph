package api;

import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class DirectedWeightedGraph_ implements DirectedWeightedGraph {
  HashMap <Integer,Node> all = new HashMap <Integer, Node>();
  HashMap <Integer,HashMap <Integer,Edge>> big = new HashMap<Integer,HashMap <Integer,Edge>>();
  HashMap <String,Edge> allofed = new HashMap<String,Edge>();
    private int mc=0;
    boolean nodes=false;
    boolean edges = false;

    public DirectedWeightedGraph_() {
        this.all = new HashMap <Integer, Node>();;
        this.big =  new HashMap<Integer,HashMap <Integer,Edge>>();
        this.allofed = new HashMap<String,Edge>();
    }

    public DirectedWeightedGraph_(String path) throws FileNotFoundException {
        File input = new File(path);
        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileoObject = fileElement.getAsJsonObject();

        List<Edge> Edges = new ArrayList<>();
        List<Node> Nodeslist = new ArrayList<>();
        JsonArray arrOfNodes = fileoObject.get("Nodes").getAsJsonArray();
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
        for (Node s : Nodeslist){
               all.put(s.getKey(),s);
        }

        for (Node n : Nodeslist) {
            n.getInfo();
            System.out.println(n.getInfo());
        }

        JsonArray arrOfEdges = fileoObject.get("Edges").getAsJsonArray();
        for (JsonElement i : arrOfEdges) {
            JsonObject ed = i.getAsJsonObject();
            int src = ed.get("src").getAsInt();
            double w = ed.get("w").getAsDouble();
            int dest = ed.get("dest").getAsInt();
            Edge e = new Edge(src, w, dest);
            Edges.add(e);
        }

            for(int index=0;index< Nodeslist.size();index++){
                HashMap<Integer, Edge> little = new HashMap<Integer, Edge>();
                for(Edge ed :Edges){
                    if (ed.getSrc()==index){
                        little.put(ed.getDest(),ed);
                        String src= String.valueOf(ed.getSrc());
                        String des= String.valueOf(ed.getDest());
                        String k = src+","+des;
                        allofed.put(k,ed);
                    }
                }
                System.out.println("l"+little.size());
                big.put(index,little);
            }
            System.out.println("b"+big.size());
            System.out.println("\n");
            System.out.println("all"+allofed.size());

        }






    @Override
    public NodeData getNode(int key) {
        return all.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        return big.get(src).get(dest);
    }

    @Override
    public void addNode(NodeData n) {
        Node adding = new Node(n.getLocation(),n.getKey());
        all.put(n.getKey(), adding);
    this.nodes=true;
    mc++;
    }

    @Override
    public void connect(int src, int dest, double w) {
    Edge adding = new Edge(src,w,dest);
    if(big.containsKey(src)){
        if(!big.get(src).containsKey(dest)){
            big.get(src).put(dest,adding);
            String sr=String.valueOf(src);
            String de=String.valueOf(dest);
            String specific = sr+","+de;
            allofed.put(specific,adding);
        }
    }
        mc++;
    this.edges= true;
    }

    @Override
    public Iterator<NodeData> nodeIter() {
        if(edges == true || nodes == true){


            throw new RuntimeException();}
         Iterator it = all.values().iterator();
        return it;
    }


    @Override
    public Iterator<EdgeData> edgeIter() {
        Iterator t = allofed.values().iterator();
        if(edges == true){
            throw new RuntimeException();}
        return t;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        if(edges == true || nodes == true){
            throw new RuntimeException();}
        Iterator it=big.get(node_id).values().iterator();
        return it ;

    }

    @Override
    public NodeData removeNode(int key) {
        nodes=true;
        Node ans = all.get(key);
        all.remove(key);
        return ans;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        edges=true;
        Edge r=null;
        if(big.containsKey(src)){
            if(big.get(src).containsKey(dest)){
                r=big.get(src).get(dest);
                big.get(src).remove(dest);
            }
        }
        String sr=String.valueOf(src);
        String de=String.valueOf(dest);
        String specific = sr+","+de;
        allofed.remove(specific);
       /// numofedges--;
        return r;
    }

    @Override
    public int nodeSize() {
        return all.size();
    }

    @Override
    public int edgeSize() {
return allofed.size();
    }

    @Override
    public int getMC() {
        return mc;
    }

}
