package api;
import java.util.Map;

public class Node  implements NodeData {

    private GeoLocation geo ;
    private int id ;


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

//        for e in Edge:
//        if (e.getsrc() == this.id) {
//            return e.getweight;
         return 0 ;
    }





    @Override
    public void setWeight(double w) {

    }


    @Override
    public String getInfo() {
        return "Node{" +
                "geo=" + geo +
                ", id=" + id +
                '}';
    }

    @Override
    public void setInfo(String s) {

    }

    @Override
    public int getTag() {
        return 0;
    }

    @Override
    public void setTag(int t) {

    }
}
