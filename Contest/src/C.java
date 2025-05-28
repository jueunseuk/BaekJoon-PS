import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> map = new HashMap<>();
        
        StringTokenizer st1;
        for (int i = 0; i < n; i++) {
        	int repeat = Integer.parseInt(br.readLine());
        	st1 = new StringTokenizer(br.readLine(), " ");
        	for(int x = 0; x < repeat; x++) {
	            int key = Integer.parseInt(st1.nextToken());
	            map.put(key, map.getOrDefault(key, 0) + 1);
        	}
        }
        
        int cnt = 0;
        for(Map.Entry<Integer, Integer> out : map.entrySet()) {
        	if(out.getValue() >= k) {
        		cnt++;
        	}
        }
        System.out.println(cnt);
        
    }
}
