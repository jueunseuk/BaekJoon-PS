import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_BJ_11976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] before = new int[4];
        int[] after = new int[4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            before[i] = Integer.parseInt(st.nextToken());
            after[i] = Integer.parseInt(st.nextToken());
        }
        int bronzeToSilver = Math.abs(before[0] - after[0]);
        int silverToGold = Math.abs(before[1] - after[1] - bronzeToSilver);
        int goldToPlatinum = Math.abs(before[2] - after[2] - silverToGold);
        System.out.println(bronzeToSilver);
        System.out.println(silverToGold);
        System.out.println(goldToPlatinum);
    }
}
