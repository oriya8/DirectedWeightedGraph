package api;

import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class DirectedWeightedGraph_ implements DirectedWeightedGraph {
   static List<Edge> Edges = new ArrayList<>();
   static List<Node> Nodeslist = new ArrayList<>();

boolean nodes=false;
boolean edges = false;

    public DirectedWeightedGraph_(String path) throws FileNotFoundException {
        File input = new File(path);
        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileoObject = fileElement.getAsJsonObject();

        JsonArray arrOfEdges = fileoObject.get("Edges").getAsJsonArray();
       // List<Edge> Edges = new ArrayList<>();
        for (JsonElement i : arrOfEdges) {
            JsonObject ed = i.getAsJsonObject();
            int src = ed.get("src").getAsInt();
            double w = ed.get("w").getAsDouble();
            int dest = ed.get("dest").getAsInt();
            Edge e = new Edge(src, w, dest);
            this.Edges.add(e);
            System.out.println(e.getInfo());
            System.out.println(" ");
        }

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
            this.Nodeslist.add(node);
        }
        for (Node n : this.Nodeslist) {
            n.getInfo();
            System.out.println(n.getInfo());
        }
    }

    public Node [] bobbuilder (){
        Node [] answer = new Node[Nodeslist.size()];
        for(Node r : Nodeslist){
            int id = r.getKey();
            answer[id]=r;
        }


        for(Edge ed : this.Edges){
           int loca = ed.getSrc();
           answer[loca].connectededges.add(ed);
        }



        return answer;
    }











    @Override
    public NodeData getNode(int key) {
        for (Node n : this.Nodeslist) {
            if(n.getKey()==key){
                return n;
            }
        }
        return null;
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        for (Edge e : this.Edges) {
            if( e.getSrc()==src && e.getDest()==dest){
                return e;
            }
        }
        return null;
    }

    @Override
    public void addNode(NodeData n) {
        Node adding = new Node(n.getLocation(),n.getKey());
    Nodeslist.add(adding);
    this.nodes=true;
    }

    @Override
    public void connect(int src, int dest, double w) {
    Edge adding = new Edge(src,w,dest);
    Edges.add(adding);
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
         Iterator it = Nodeslist.iterator();
        return it;
    }


    @Override
    public Iterator<EdgeData> edgeIter() {
        if(edges == true){
            throw new RuntimeException();}
        Iterator it = Edges.iterator();
        return it;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        if(edges == true || nodes == true){
            throw new RuntimeException();}
        for (Node n : this.Nodeslist) {
            if(n.getKey()==node_id){
                Iterator it = n.connectededges.iterator();
                return it ;
            }
        }
        return null;
    }

    @Override
    public NodeData removeNode(int key) {
        nodes=true;
        Node ans = null;
        for (Node n : this.Nodeslist) {
            if(n.getKey()==key){
                Nodeslist.remove(n);
                ans=n;
            }
        }
        return ans;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        edges=true;
        return null;
    }

    @Override
    public int nodeSize() {
        return Nodeslist.size();
    }

    @Override
    public int edgeSize() {
        return Edges.size();
    }

    @Override
    public int getMC() {
        return 0;
    }

}
