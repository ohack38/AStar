import java.util.Scanner;

public class Utils {

    public static double getDistance(double lon1, double lat1, double lon2, double lat2) {
        lon1 = lon1 * Math.PI / 180.0;
        lat1 = lat1 * Math.PI / 180.0;
        lon2 = lon2 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double km = 6367 * c;

        return km;
    }
    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String i = scanner.nextLine().trim();
        int val = 0;
        switch (i) {
            case "bole":
                val = 0;
                break;
            case "vall":
                val = 1;
                break;
            case "berg":
                val = 2;
                break;
            case "tolo":
                val = 3;
                break;
            case "oodi":
                val = 4;
                break;
            case "rich":
                val = 5;
                break;
            case "bush":
                val = 6;
                break;
            default:
                val = 7;

        }

        return val;
    }
}
