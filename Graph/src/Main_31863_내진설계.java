import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31863_내진설계 {
	static int row, col, building = 0, collapse = 0;
	static Section[][] matrix;
	
	static Queue<EQ> q = new ArrayDeque<>();
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new Section[row][col];
        
        char[] input;
        for(int i = 0; i < row; i++) {
        	input = br.readLine().toCharArray();
        	
        	for(int j = 0; j < col; j++) {
        		if(input[j] == '.') {
        			matrix[i][j] = new Section(input[j], 0);
        		} else if(input[j] == '#') {
        			building++;
        			matrix[i][j] = new Section(input[j], 2);
        		} else if(input[j] == '*') {
        			building++;
        			matrix[i][j] = new Section(input[j], 1);
        		} else if(input[j] == '|') {
        			matrix[i][j] = new Section(input[j], 0);
        		} else {
        			matrix[i][j] = new Section('.', 0);
        			q.offer(new EQ(i, j, 2));
        		}
        	}
        }
        
        bfs();
	}

	public static void bfs() {
		while(!q.isEmpty()) {
			EQ poll = q.poll();
			
			
			if(matrix[poll.x][poll.y].v == '#') {
				
			} else if(matrix[poll.x][poll.y].v == '*') {
				q.offer(new EQ(poll.x, poll.y, 1));
			}
			
			if(poll.remain <= 0) {
				continue;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll.x + dx[delta];
				int ny = poll.y + dy[delta];
				
				if(nx >=0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny].v != '|') {
					q.offer(new EQ(nx, ny, poll.remain-1));
				}
			}
		}
	}
	
	public static class EQ {
		int x;
		int y;
		int remain;
		
		public EQ(int x, int y, int remain) {
			this.x = x;
			this.y = y;
			this.remain = remain;
		}
	}
	
	public static class Section {
		char v;
		int hp;
		
		public Section(char v, int hp) {
			this.v = v;
			this.hp = hp;
		}
	}
}