package api;
import java.util.HashMap;
import java.util.Map;

public class Edge implements EdgeData {

    private int src , dest ;
    private double weight ;
    private int tag;


    public Edge(int s,double w, int d ) {

        this.src = s ;
        this.dest = d ;
        this.weight = w ;

    }



    @Override
    public int getSrc() {
        return this.src;
    }

    @Override
    public int getDest() {
        return this.dest;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getInfo() {
        return "Edge{" +
                "src=" + src +
                ", weight=" + weight +
                ", dest=" + dest +
                '}';
    }

    @Override
    public void setInfo(String s) {

       String [] arr = new String[3];
        Map<String, String> myMap = new HashMap<String, String>();
        String[] pairs = s.split(",");
        for (int i=0;i<pairs.length;i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            myMap.put(keyValue[0], String.valueOf(keyValue[1]));

        }

        int kk = 0;
        for (Map.Entry<String, String> e : myMap.entrySet()){
           arr[kk]= e.getValue();
           kk++;
    }
        this.dest = Integer.parseInt(arr[0]);
        this.weight = Double.parseDouble(arr[2]);
        this.src = Integer.parseInt(arr[1]);

    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
    this.tag=t;
    }
}
