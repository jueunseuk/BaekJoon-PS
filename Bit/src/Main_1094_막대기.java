import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main_1094_막대기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		while(n > 0) {
			if(n%2 == 1) {
				count++;
			}
			n = n >> 1;
		}
		System.out.println(count);
	}

}
