import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1074_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(Z(n, r, c));
		
		
	}

	private static int Z(int n, int r, int c) {
		
		if(n==0) return 0;
		
		int half = 1 << (n-1);
		int square = half*half;
		
		if(r < half && c < half) {
			return Z(n-1, r, c);
		} else if(r < half && c >= half) {
			return square + Z(n-1, r, c - half);
		} else if(r >= half && c < half) {
			return 2*square + Z(n-1, r-half, c);
		} else {
			return 3*square + Z(n-1, r-half, c-half);
		}
		
		
	}
	
	
	
	
}
