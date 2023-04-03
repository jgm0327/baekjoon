import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int n, m;
	private static int[][] graph;
	private static boolean[][] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str[] = br.readLine().split(" ");
			m = Integer.parseInt(str[0]);
			n = Integer.parseInt(str[1]);
			if(n == 0 && m == 0)break;
			
			graph = new int[n][m];
			for(int i=0 ; i<n ; i++) {
				String[] input = br.readLine().split(" ");
				for(int j=0 ; j<m ; j++) {
					graph[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			System.out.println(countIslands());
			
		}
		br.close();
	}
	
	public static int countIslands() {
		int cnt = 0;
		visit = new boolean[n][m];
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(!visit[i][j] && graph[i][j] == 1) {
					visit[i][j] = true;
					bfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {y, x});
		int[] dy = {0, 1, 1, 1, 0, -1, -1, -1}, dx = {1, 1, 0, -1, -1, -1, 0, 1};
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int curY = cur[0], curX = cur[1];
			for(int i=0 ; i<8 ; i++) {
				int ny = curY + dy[i], nx = curX + dx[i];
				if(((0 <= ny && ny < n) && (0 <= nx && nx < m)) && !visit[ny][nx] && graph[ny][nx] == 1) {
					visit[ny][nx] = true;
					que.add(new int[] {ny, nx});
				}
			}
		}
	}
}
