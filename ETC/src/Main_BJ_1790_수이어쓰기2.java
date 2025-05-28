import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_BJ_1790_수이어쓰기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		Deque<Integer> deq = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) {
			
			deq.addLast(i);
			
		}
		
		
	}

}
