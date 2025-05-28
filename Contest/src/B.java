import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long R = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long halvings = M / K;

        long reward = R;
        for (long i = 0; i < halvings; i++) {
            reward /= 2;
            if (reward < 1) {
                reward = 0;
                break;
            }
        }

        System.out.println(reward);
    }
}
