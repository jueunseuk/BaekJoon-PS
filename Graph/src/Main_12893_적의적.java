import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12893_적의적 {
	static int n, m;
	static List<List<Integer>> list = new ArrayList<>();
	static int visit[];
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	if(m == 0) {
    		System.out.println(1);
    		return;
    	}
    	
    	visit = new int[n+1];
    	for(int i = 0; i <= n; i++) {
    		list.add(new ArrayList<>());
    	}
    	
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		
    		list.get(start).add(end);
    		list.get(end).add(start);
    	}
    	
    	boolean result = true;
    	for(int i = 1; i <= n; i++) {
    		if(visit[i] == 0) {
    			result =bfs(i);
    		}
    		
    		if(!result) {
    			break;
    		}
    	}
    	
    	System.out.println(result ? 1 : 0);
	}

	private static boolean bfs(int i) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(i);
		visit[i] = 1;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int out : list.get(poll)) {
				if(visit[out] == 0) {
					q.offer(out);
					visit[out] = -visit[poll];
				} else if(visit[out] == visit[poll]) {
					return false;
				}
			}
		}
		
		return true;
	}
}