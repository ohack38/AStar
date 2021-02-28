import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        GraphData graphData = new GraphData();
        graphData.showNodesAndLinks(graphData.createGraph());
        System.out.println("Startpunkt: ");
        Node start = graphData.createGraph().get(Utils.getUserInput());
        System.out.println("Ändpunkt: ");
        Node destination = graphData.createGraph().get(Utils.getUserInput());

        ArrayList<Node> routeready = getRoute(start, destination);
        System.out.format("\nStartpunkt: %s \nDestination: %s \nKortaste rutt:\n", start.getId(), destination.getId());
        for (Node routeItem : routeready) {
            System.out.println((routeready.indexOf(routeItem)+1) + ". " + routeItem.getName());

        }

    }

    public static ArrayList<Node> getRoute(Node start, Node destination) {
        boolean done = false;
        ArrayList<Node> candidates = new ArrayList<>();
        ArrayList<Node> Visited = new ArrayList<>();
        Node current = start;
        Node next = null;


        while (!done) {
            double minF = 0;
            double F;
            for (Node neighbour : current.getNeighbours()) {

                if (!Visited.contains(neighbour) && !candidates.contains(neighbour)) {
                    candidates.add(neighbour);
                    neighbour.setPrevious(current);

                }
            }
            for (Node candidate : candidates) {
                if (candidate.getName().equals(destination.getName())) {
                    done = true;
                    break;
                } else {
                    F = candidate.getF(destination, start);

                    if (minF == 0 || minF > F) {
                        minF = F;
                        next = candidate;
                    }
                }
            }
            if (!done) {
                current = next;
                Visited.add(current);
                candidates.remove(current);

            }
        }

        ArrayList<Node> route = new ArrayList<>();
        current.setCurrent(destination);
        // börjar routen med sista noden och lägger till starten efter loopen för
        // while loopen körs i reverse.. efter det reversar vi routen till rätt håll
        route.add(destination);
        while (!current.getId().equals(start.getId())) {
            route.add(current);
            current = current.previous;

        }
        // Ta destination med i routen
        route.add(start);
        //reverse route
        Collections.reverse(route);
        return route;

    }
}


