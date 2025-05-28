import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11664_선분과점 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        
        double x1 = Double.parseDouble(st.nextToken()), y1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken()), y2 = Double.parseDouble(st.nextToken());

        double px = Double.parseDouble(st.nextToken()), py = Double.parseDouble(st.nextToken());

        double distance = distancePointToLine(px, py, x1, y1, x2, y2);
        System.out.println("점과 직선 사이의 최단 거리: " + distance);
    }

    public static double distancePointToLine(
            double px, double py,
            double x1, double y1,
            double x2, double y2) {
        
        double numerator = Math.abs((y2 - y1) * px 
                                  - (x2 - x1) * py
                                  + x2 * y1
                                  - y2 * x1);

        double denominator = Math.sqrt(Math.pow(y2 - y1, 2)
                                     + Math.pow(x2 - x1, 2));

        if (denominator == 0.0) {
            return Math.sqrt(Math.pow(px - x1, 2) + Math.pow(py - y1, 2));
        }

        return numerator / denominator;
    }
}
