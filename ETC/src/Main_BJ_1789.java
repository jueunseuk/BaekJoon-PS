import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_1789 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		long sum = 0;
		int i = 0;
        
        while (sum <= N) {
            i++;
            sum += i;
        }
        
        System.out.println(i-1);
	}

}
