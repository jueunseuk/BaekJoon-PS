import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BJ_15664 {
    static int N, R;
    static int[] input;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        input = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        result = new int[R];

        recur(0, 0);
        
        for(String out : set)
        System.out.print(out);
    }

    private static void recur(int depth, int idx) {
        if (depth == R) {
            Arrays.sort(result);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < result.length; i++) {
            	sb.append(i).append(" ");
            }
            set.add(sb.toString().trim());
            return;
        }
        for (int i = idx; i < N; i++) {
            result[depth] = input[i];
            recur(depth + 1, i+1);
        }
    }
}
