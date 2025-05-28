import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_33510_이상한나누기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int length = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder(br.readLine());
        sb.reverse();
        
        int oddCnt = 0;
        while(sb.length() > 1) {
        	while(sb.length() > 0 && sb.charAt(0) == '0') {
        		sb.deleteCharAt(0);
        	}
        	
        	if(sb.length() > 0 && sb.charAt(0) == '1') {
        		sb.deleteCharAt(0);
        		oddCnt++;
        		
        		while(sb.length() > 0 && sb.charAt(0) == '1') {
        			sb.deleteCharAt(0);
        		}
        		
        		if(sb.length() == 0) {
        			sb.append(1);
        		} else {
        			sb.replace(0, 1, "1");
        		}
        	}
        }
        
        System.out.println(oddCnt);
	}

}
