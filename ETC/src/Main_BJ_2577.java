import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2577 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int total = A*B*C;
		
		int arr[] = new int[10];
		Arrays.fill(arr, 0);
		
		while(total != 0) {
			arr[total%10]++;
			total /= 10;
		}
		for(int i = 0; i < 10; i++)
		System.out.println(arr[i]);
	}

}
