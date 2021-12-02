package api;

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
         for ( JsonElement i : arrOfEdges){

             JsonObject ed = i.getAsJsonObject();

             int src = ed.get("src").getAsInt();
             double w = ed.get("w").getAsDouble();
             int dest = ed.get("dest").getAsInt();

             Edge e = new Edge(src,w,dest);
             Edges.add(e);

         }

         System.out.println(Edges);













//        FileReader reader = new FileReader("G1.json");
//
//        Object obj = jsonParser.parse(reader);
//
//        JSONArray employeeList = (JSONArray) obj;
//        System.out.println(employeeList) ;
//
//
//
//         Gson gson = new Gson();
//         String gsons = gson.toJson();
//         System.out.println("het");
















    }

}
