import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_33510_이상한나누기2 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int length = Integer.parseInt(br.readLine());
        
        char[]input = br.readLine().toCharArray();
        
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = length-1; i >= 0; i--) {
        	q.offer(input[i]-'0');
        }
        
        int oddCnt = 0;
        while(q.size() > 1) {
        	while(q.size() > 1 && q.peekFirst() == 0) {
        		q.pollFirst();
        	}
        	
        	if(q.size() > 1 && q.peekFirst() == 1) {
        		q.pollFirst();
        		oddCnt++;
        		
        		while(q.size() > 0 && q.peekFirst() == 1) {
        			q.pollFirst();
        		}
        		
        		if(q.size() == 0) {
        			q.offerFirst(1);
        		} else {
        			q.pollFirst();
        			q.offerFirst(1);
        		}
        	}
        }
        
        System.out.println(oddCnt);
	}
}