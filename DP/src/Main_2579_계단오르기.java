import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] input = new int[n+1];
        
        for(int i = 1; i <= n; i++) {
        	input[i] = Integer.parseInt(br.readLine());
        }
        
        int[]dp = new int[n+1];
        dp[1] = input[1];
        if(n >= 2)
        dp[2] = input[1]+input[2];
        if(n >= 3)
    	dp[3] = Math.max(input[1] + input[3], input[2] + input[3]);
        
        for(int i = 4; i <= n; i++) {
        	dp[i] = Math.max(dp[i-2]+input[i], dp[i-3]+input[i-1]+input[i]);
        }
        
        System.out.println(dp[n]);
	}

}
