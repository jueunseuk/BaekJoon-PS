import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] xCoords = new int[N];
        int[] yCoords = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            xCoords[i] = Integer.parseInt(st.nextToken());
            yCoords[i] = Integer.parseInt(st.nextToken());
        }

        int medianX = findMedian(xCoords);
        int medianY = findMedian(yCoords);

        long totalEnergy = 0;
        for (int i = 0; i < N; i++) {
            totalEnergy += calculateEnergy(xCoords[i], medianX, A, B);
            totalEnergy += calculateEnergy(yCoords[i], medianY, C, D);
        }

        System.out.println(totalEnergy);
    }

    private static int findMedian(int[] coords) {
        Arrays.sort(coords);
        int n = coords.length;
        if (n % 2 == 1) {
            return coords[n / 2];
        } else {
            return coords[n / 2 - 1];
        }
    }

    private static long calculateEnergy(int current, int target, int costNegative, int costPositive) {
        if (current < target) {
            return (long) (target - current) * costPositive;
        } else {
            return (long) (current - target) * costNegative;
        }
    }
}
