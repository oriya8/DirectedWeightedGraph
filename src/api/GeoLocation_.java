package api;

public class GeoLocation_ implements GeoLocation{

    private double x;
    private double y;
    private double z;


    public GeoLocation_(double a,double b,double c){

        this.x=a;
        this.y=b;
        this.z=c;

    }

    public GeoLocation_(GeoLocation G){
        this(G.x(),G.y(),G.z());


    }




    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y +
                ", z=" + z ;
    }


    @Override
    public double x() {
        return this.x;
    }

    @Override
    public double y() {
        return this.y;
    }

    @Override
    public double z() {
        return this.z;
    }

    @Override
    public double distance(GeoLocation g) {

        double x1 = (this.x - g.x());
        double y1 = (this.y - g.y());
        double z1 = (this.z - g.z());

        return Math.sqrt((x1*x1)+(y1*y1)+(z1*z1));

    }
}
