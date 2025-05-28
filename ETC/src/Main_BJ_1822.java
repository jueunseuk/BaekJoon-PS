import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ_1822 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < A; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < B; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}
		
		setA.removeAll(setB);
		ArrayList<Integer> list = new ArrayList<>(setA);
		Collections.sort(list);
		
		
		if(list.size() == 0) {
            bw.write("0\n");
        } else {
            bw.write(list.size() + "\n");
            for(int i = 0; i < list.size(); i++) {
                bw.write(list.get(i) + (i < list.size() - 1 ? " " : ""));
            }
            bw.write("\n");
        }
		
		bw.flush();
        bw.close();
        br.close();

	}

}
