import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_10866_덱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String command = st.nextToken();
			
			
			switch(command) {
				case "push_front" : {
					int number = Integer.parseInt(st.nextToken());
						q.addFirst(number);
						break;
				}
				case "push_back" : {
					int number = Integer.parseInt(st.nextToken());
					q.addLast(number);
					break;
				}
				case "pop_front" : {
					System.out.println(q.isEmpty() ? -1 : q.removeFirst());
					break;
				}
				case "pop_back" : {
					System.out.println(q.isEmpty() ? -1 : q.removeLast());
					break;
				}
				case "size" : {
					System.out.println(q.size());
					break;
				}
				case "empty" : {
					System.out.println(q.isEmpty() ? 1 : 0);
					break;
				}
				case "front" : {
					System.out.println(q.isEmpty() ? -1 : q.peekFirst());
					break;
				}
				case "back" : {
					System.out.println(q.isEmpty() ? -1 : q.peekLast());
					break;				
				}
			}
		}//for
		br.close();
	}

}
