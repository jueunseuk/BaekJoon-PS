import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1402 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int Aprime = Integer.parseInt(st.nextToken());
            
            int sum = 0;
            int sqrt = (int) Math.sqrt(A);
            
            for (int i = 2; i <= sqrt; i++) {
                if (A % i == 0) {
                    if (i != A) {
                        sum += i;
                    }
                    int otherDivisor = A / i;
                    if (otherDivisor != i && otherDivisor != A) {
                        sum += otherDivisor;
                    }
                }
            }
            
            if (sum == Aprime) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
