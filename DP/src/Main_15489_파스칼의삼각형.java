import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15489_파스칼의삼각형 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int w = Integer.parseInt(st.nextToken());
        
        int dp[][] = new int[31][];
        
        dp[0] = new int[1];
        dp[0][0] = 1;
        dp[1] = new int[2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        
        for(int i = 2; i <= 30; i++) {
        	dp[i] = new int[i+1];
        	for(int j = 0; j <= i; j++) {
        		if(j == 0 || j == i) {
        			dp[i][j] = 1;
        		} else {
        			dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
        		}
        	}
        }
        
        long sum = 0;
        
        for(int i = 0; i < w; i++) {
        	for(int j = 0; j <= i; j++) {
        		sum += dp[r+i][j+c];
        	}
        }
        
        System.out.println(sum);
        
	}
}
