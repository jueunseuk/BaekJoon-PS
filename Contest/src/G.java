import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long currentValue = 0;
        for (int i = 1; i <= N; i++) {
            currentValue += Math.abs(A[i] - i);
        }

        long maxValue = currentValue;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                long newValue = currentValue;

                newValue -= Math.abs(A[i] - i) + Math.abs(A[j] - j);
                newValue += Math.abs(A[j] - i) + Math.abs(A[i] - j);

                maxValue = Math.max(maxValue, newValue);
            }
        }

        System.out.println(maxValue);
    }
}
