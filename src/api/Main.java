package api;

import com.google.gson.*;
import com.sun.org.apache.bcel.internal.generic.NEW;

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

        for ( JsonElement i : arrOfEdges){

             JsonObject ed = i.getAsJsonObject();
             int src = ed.get("src").getAsInt();
             double w = ed.get("w").getAsDouble();
             int dest = ed.get("dest").getAsInt();

             Edge e = new Edge(src,w,dest);
             Edges.add(e);
             System.out.println(e.getInfo());
             System.out.println(" ");
             String ss = "\"src\":4,\"w\":4.2, \"dest\":8";
             e.setInfo(ss);
             System.out.println(e.getInfo());

        }


        JsonArray arrOfNodes = fileoObject.get("Nodes").getAsJsonArray();
        List<Node> Nodes = new ArrayList<>();
        for ( JsonElement i : arrOfNodes){

            JsonObject nd = i.getAsJsonObject();
            String l = nd.get("pos").getAsString();
            String [] NZ = new String [3];
            NZ =l.split(",");
            double a=Double.parseDouble(NZ[0]);
            double b=Double.parseDouble(NZ[1]);
            double c=Double.parseDouble(NZ[2]);
            GeoLocation_ pos = new GeoLocation_(a,b,c);
            int id = nd.get("id").getAsInt();

            Node node = new Node( pos,id);
            Nodes.add(node);

            node.getInfo();


        }














    }

}
