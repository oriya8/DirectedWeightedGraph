package api;

public class Edge implements EdgeData {

    int src , dest ;
    double weight ;

    public Edge(int s,double w, int d ) {

        this.src = s ;
        this.dest = d ;
        this.weight = w ;

    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", weight=" + weight +
                ", dest=" + dest +
                '}';
    }

    @Override
    public int getSrc() {
        return 0;
    }

    @Override
    public int getDest() {
        return 0;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public String getInfo() {
        return null;
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
