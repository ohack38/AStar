import java.util.ArrayList;

public class Node {
    public double G = 0;
    public String name;
    public String id;
    public double latitude;
    public double longitude;
    public Node current;
    public Node previous;
    public ArrayList<Node> neighbours = new ArrayList<>();

    public Node(String name, double latitude, double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Node neighbour ) {
        neighbours.add(neighbour);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public double calculateH (Node candidate,Node destination){
        double lon1 = destination.getLongitude();
        double lat1 = destination.getLatitude();

        double lon2 = candidate.getLongitude();
        double lat2 = candidate.getLatitude();
        double distance = Utils.getDistance(lon1, lat1, lon2, lat2);
        return distance;
    }
    public double calculateG( Node source){
        G=0;
        Node current = this;
        while(current != source ){
            double lon2 = current.previous.getLongitude();
            double lat2 = current.previous.getLatitude();

            double lon1 = current.getLongitude();
            double lat1 = current.getLatitude();

            G += Utils.getDistance(lon1, lat1, lon2, lat2);
            current = current.previous;
            //current.setPrevious(current.previous);
        }

        return G;

    }
    public double getF(Node goal, Node source){

        double H =calculateH(this,goal);
        double G = calculateG(source);
        return G+H;
    }

    public Node getCurrent() {
        return current;
    }

    public void setCurrent(Node current) {
        this.current = current;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
