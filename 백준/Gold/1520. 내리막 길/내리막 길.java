import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int n, m, answer;
	private static int[][] graph, dp;
	private static int[] dy, dx;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		m = Integer.parseInt(size[1]);
		
		graph = new int[n][m];
		for(int i=0 ; i<n ; i++) {
			String[] values = br.readLine().split(" ");
			for(int j=0 ; j<m ; j++) {
				graph[i][j] = Integer.parseInt(values[j]);
			}
		}
		
		dp = new int[n][m];
		for(int i=0 ; i<n ; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		dy = new int[] {0,0,1,-1};
		dx = new int[] {1,-1,0,0};
		System.out.println(dfs(0, 0));
		
		br.close();
	}
	
	private static int dfs(int y, int x) {
		if(y == n - 1 && x == m - 1) {
			return 1;
		}
		if(dp[y][x] != -1)
			return dp[y][x];
		
		dp[y][x] = 0;
		for(int i=0 ; i<4 ; i++) {
			int ny = y + dy[i], nx = x + dx[i];
			if((0 <= ny && ny < n && 0 <= nx && nx < m) && graph[y][x] > graph[ny][nx]) {
				dp[y][x] += dfs(ny, nx);
			}
		}
		return dp[y][x];
	}
}
