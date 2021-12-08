package api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Ex2.getGrapg("data\\G1.json");
//        DirectedWeightedGraph kkk = new DirectedWeightedGraph_("data\\G1.json");
//        File input = new File("data\\G1.json");
//        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
//        JsonObject fileoObject = fileElement.getAsJsonObject();
//
//        List<Edge> Edges = new ArrayList<>();
//        List<Node> Nodeslist = new ArrayList<>();
//        JsonArray arrOfNodes = fileoObject.get("Nodes").getAsJsonArray();
//        for (JsonElement i : arrOfNodes) {
//            JsonObject nd = i.getAsJsonObject();
//            String l = nd.get("pos").getAsString();
//            System.out.println(l);
//            String[] NZ;
//            NZ = l.split(",");
//            double a = Double.parseDouble(NZ[0]);
//            double b = Double.parseDouble(NZ[1]);
//            double c = Double.parseDouble(NZ[2]);
//            GeoLocation_ pos = new GeoLocation_(a, b, c);
//            int id = nd.get("id").getAsInt();
//            Node node = new Node(pos, id);
//            Nodeslist.add(node);
//
//        }
//        // List<Edge> Edges = new ArrayList<>();
//
//        //HashMap <Integer,HashMap <Integer,Edge>> fulledge = new HashMap<Integer,HashMap <Integer,Edge>>();
//
//        JsonArray arrOfEdges = fileoObject.get("Edges").getAsJsonArray();
//        for (JsonElement i : arrOfEdges) {
//            JsonObject ed = i.getAsJsonObject();
//            int src = ed.get("src").getAsInt();
//            double w = ed.get("w").getAsDouble();
//            int dest = ed.get("dest").getAsInt();
//            Edge e = new Edge(src, w, dest);
//            Edges.add(e);
//        }
//        HashMap <Integer,HashMap <Integer,Edge>> big = new HashMap<Integer,HashMap <Integer,Edge>>();
//        HashMap <Integer,Edge> allofed = new HashMap<Integer,Edge>();
//        int allin = 0;
//        for(int index=0;index< Nodeslist.size();index++){
//            HashMap<Integer, Edge> little = new HashMap<Integer, Edge>();
//            for(Edge ed :Edges){
//                if (ed.getSrc()==index){
//                    little.put(ed.getDest(),ed);
//                    allofed.put(allin,ed);
//                    allin++;
//                }
//            }
//            System.out.println("l"+little.size());
//
//            big.put(index,little);
//        }
//        System.out.println("b"+big.size());
//        System.out.println("\n");
//        System.out.println("all"+allofed.size());
//        Iterator t = allofed.values().iterator();
//
//
//
//
//        //numofedges=Edges.size();
////        for (Node d : Nodeslist) {
////            this.all.put(d.getKey(),d);
////        }
//
//        for (Node n : Nodeslist) {
//            n.getInfo();
//            System.out.println(n.getInfo());
//        }
//    }
//
////    public Iterator<EdgeData> edgeIter() {
////
////
////
////        return null;
////
   }


}