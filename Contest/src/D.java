import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        if (K % 2 != 0) {
            System.out.println(-1);
            return;
        }

        long pairsNeeded = K / 2;
        long totalPairs = 0;

        for (int i = 0; i < N; i++) {
            totalPairs += A[i] / 2;
            if (totalPairs >= pairsNeeded) {
                System.out.println(K);
                return;
            }
        }

        System.out.println(-1);
    }
}