import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_33510_이상한나누기3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int length = Integer.parseInt(br.readLine());
        String input = br.readLine();
        
        char[] bits = new char[length + 2];
        for (int i = 0; i < bits.length; i++) {
            bits[i] = '0';
        }
        
        for (int i = 0; i < length; i++) {
            bits[i] = input.charAt(length - 1 - i);
        }

        int end = length - 1;

        int start = 0;
        int oddCount = 0;

        while (true) {
            while (start <= end && bits[start] == '0') {
                start++;
            }

            if (start > end) {
                System.out.println(oddCount);
                return;
            }
            if (start == end && bits[end] == '1') {
                System.out.println(oddCount);
                return;
            }

            if (bits[start] == '0') {
                start++;
            } else {
                oddCount++;

                int idx = start;
                while (idx <= end && bits[idx] == '1') {
                    bits[idx] = '0';
                    idx++;
                }
                
                if (idx <= end) {
                    bits[idx] = '1';
                } else {
                    end++;
                    bits[end] = '1';
                }
                
                start++;
            }
        }
    }
}
