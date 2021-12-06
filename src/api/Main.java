package api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("data\\G1.json");
        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileoObject = fileElement.getAsJsonObject();

        JsonArray arrOfEdges = fileoObject.get("Edges").getAsJsonArray();
        List<Edge> Edges = new ArrayList<>();

        for (JsonElement i : arrOfEdges) {

            JsonObject ed = i.getAsJsonObject();
            int src = ed.get("src").getAsInt();
            double w = ed.get("w").getAsDouble();
            int dest = ed.get("dest").getAsInt();

            Edge e = new Edge(src, w, dest);
            Edges.add(e);
            System.out.println(e.getInfo());
            System.out.println(" ");


        }


        JsonArray arrOfNodes = fileoObject.get("Nodes").getAsJsonArray();
        List<Node> Nodeslist = new ArrayList<>();
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

            for (Edge e : Edges) {

                if (e.getSrc() == id) {
                    // node.weight=id;
                    System.out.println(id);

                }
            }

            Nodeslist.add(node);
        }

        for (Node n : Nodeslist) {
            n.getInfo();
            System.out.println(n.getInfo());

        }

    }


}
