import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11726_2n타일링 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		if(n==1) {
			System.out.println(1);
			return;
		} else if(n==2) {
			System.out.println(2);
			return;
		}
		
		int dp[] = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}
		
		System.out.println(dp[n]);
	}

}
