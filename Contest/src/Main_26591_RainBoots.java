import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_26591_RainBoots {
	static int size = 8;
	static char[][] matrix;
	static boolean[][] visit;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
        	matrix = new char[size][size];
        	
        	int x1, y1, x2, y2;
        	x1 = y1 = x2 = y2 = 0;
        	for(int i = 0; i < size; i++) {
        		matrix[i] = br.readLine().toCharArray();
        		
        		for(int j = 0; j < size; j++) {
        			if(matrix[i][j] == 'S') {
        				x1 = i;
        				y1 = j;
        				matrix[i][j] = '.';
        			} else if(matrix[i][j] == 'E') {
        				x2 = i;
        				y2 = j;
        				matrix[i][j] = '.';
        			}
        		}
        	}
        	
        	bfs(x1, y1, x2, y2);
        	
        	String input = br.readLine();
        	if(input.isBlank() && input.isEmpty()) {
        		break;
        	}
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void bfs(int x1, int y1, int x2, int y2) {
		Deque<int[]> q = new ArrayDeque<>();
		visit = new boolean[size][size];
		
		q.offer(new int[] {x1, y1, 0});
		visit[x1][y1] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == x2 && poll[1] == y2) {
				sb.append(poll[2]).append("\n");
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < size && ny < size && !visit[nx][ny]) {
					if(matrix[nx][ny] == 'M') {
						q.offerLast(new int[] {nx, ny, poll[2]+1});
					} else {
						q.offerFirst(new int[] {nx, ny, poll[2]});
					}
					visit[nx][ny] = true;
				}
			}
		}
	}
}