package api;
import java.util.*;

public class Node implements NodeData {

    private GeoLocation geo ;
    private int id ;
    private int Tag = 0;
    private double weight = 0 ;
   // List<EdgeData> connectededges = new ArrayList<>();
   // HashMap <Integer,Edge> conedges = new HashMap<Integer, Edge>();

   //  int s = conedges.size();

    public Node(GeoLocation g , int id){
        this.geo = new GeoLocation_(g) ;
        this.id = id ;

    }



    @Override
    public int getKey() {
        return this.id;
    }

    @Override
    public GeoLocation getLocation() {
        return this.geo;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.geo=p;

    }

    @Override
    public double getWeight() {
         return this.weight ;
    }





    @Override
    public void setWeight(double w) {
    this.weight=w;
    }


    @Override
    public String getInfo() {
        return "Node{" +
                "geo=" + geo +
                ", id=" + id +
                ", w=" + weight +
                " tag=" + Tag +
                '}';
    }

    @Override
    public void setInfo(String s) {

    }

    @Override
    public int getTag() {
        return this.Tag;
    }

    @Override
    public void setTag(int t) {
    this.Tag=t;
    }
}
