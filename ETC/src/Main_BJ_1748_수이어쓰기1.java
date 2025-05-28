import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1748_수이어쓰기1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp = (int) Math.floor(Math.log10(N));
		
		int digit = 1;
        int length = 0;
        int start = 1;
        
        while (start <= N) {
            int end = start * 10 - 1;
            if (end > N) {
                end = N;
            }
            length += (end - start + 1) * digit;
            digit++;
            start *= 10;
        }
		
		System.out.println(length);
		
		
	}

}
