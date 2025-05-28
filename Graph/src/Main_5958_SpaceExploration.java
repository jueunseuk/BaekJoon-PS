import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5958_SpaceExploration {
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static char matrix[][];
	static boolean visit[][];
	static int row, col, cnt = 0;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        row = col = N;
        
        matrix = new char[row][col];
        visit = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        }
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(!visit[i][j] && matrix[i][j] == '*') {
        			dfs(i, j);
        			cnt++;
        		}
        	}
        }
        
        System.out.println(cnt);

	}

	private static void dfs(int i, int j) {
		visit[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx < row && nx >= 0 && ny < col && ny >= 0 && !visit[nx][ny] && matrix[nx][ny] == '*') {
				dfs(nx, ny);
			}
		}
	}

}
