package api;
import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class DirectedWeightedGraph_ implements DirectedWeightedGraph {

public class Main {

    public void main(String[] args) throws FileNotFoundException {

        File input = new File("data\\G1.json");
        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileoObject = fileElement.getAsJsonObject();

        JsonArray arrOfEdges = fileoObject.get("Edges").getAsJsonArray();
        List<Edge> Edges = new ArrayList<>();

        for (JsonElement i : arrOfEdges) {

            JsonObject ed = i.getAsJsonObject();
//            String st = "";
            int src = ed.get("src").getAsInt();
            double w = ed.get("w").getAsDouble();
            int dest = ed.get("dest").getAsInt();

//             st += ed.get("src").getAsString();
//             st += ed.get("w").getAsString();
//             st += ed.get("dest").getAsString();
            Edge e = new Edge(src, w, dest);
            Edges.add(e);
            System.out.println(e.getInfo());
            System.out.println(" ");
            String ss = "\"src\":4,\"w\":4.2, \"dest\":8";
            e.setInfo(ss);
            System.out.println(e.getInfo());

        }


        JsonArray arrOfNodes = fileoObject.get("Nodes").getAsJsonArray();
        List<Node> Nodes = new ArrayList<>();

    }
    }



        @Override
        public NodeData getNode(int key) {
            return null;
        }

        @Override
        public EdgeData getEdge(int src, int dest) {
            return null;
        }

        @Override
        public void addNode(NodeData n) {

        }

        @Override
        public void connect(int src, int dest, double w) {

        }

        @Override
        public Iterator<NodeData> nodeIter() {
            return null;
        }

        @Override
        public Iterator<EdgeData> edgeIter() {
            return null;
        }

        @Override
        public Iterator<EdgeData> edgeIter(int node_id) {
            return null;
        }

        @Override
        public NodeData removeNode(int key) {
            return null;
        }

        @Override
        public EdgeData removeEdge(int src, int dest) {
            return null;
        }

        @Override
        public int nodeSize() {
            return 0;
        }

        @Override
        public int edgeSize() {
            return 0;
        }

        @Override
        public int getMC() {
            return 0;
        }

}
