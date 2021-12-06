package api;
import java.util.Map;

public class Node implements NodeData {

    private GeoLocation geo ;
    private int id ;
    private double weight = 0;
     private int Tag = 0;


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
                " w=" + weight +
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
