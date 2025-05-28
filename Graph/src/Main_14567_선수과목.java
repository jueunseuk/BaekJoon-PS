import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14567_선수과목 {
	static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] top;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        top = new int[n+1];
        dp = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(end);
        	top[end]++;
        }
        
        topologicalSort();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
        	sb.append(dp[i]+" ");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void topologicalSort() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= n ;i++) {
			if(top[i] == 0) {
				q.offer(i);
				dp[i] = 1;
			}
		}
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int out : list.get(poll)) {
				dp[out] = Math.max(dp[out], dp[poll]+1);
				if(--top[out] == 0) {
					q.offer(out);
				}
			}
		}
	}
}