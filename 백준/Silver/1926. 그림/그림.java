import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int n, m;
	private static int[][] picture;
	private static boolean[][] visit;
	
	public static void main(String[] args) throws IOException{
		init();
		solution();
	}
	
	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		m = Integer.parseInt(size[1]);
		
		picture = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0 ; i<n ; i++) {
			String[] values = br.readLine().split(" ");
			for(int j=0 ; j<m ; j++) {
				picture[i][j] = Integer.parseInt(values[j]);
			}
		}
		
		br.close();
	}
	
	private static void solution() {
		int max = 0, cnt = 0;
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(!visit[i][j] && picture[i][j] == 1) {
					visit[i][j] = true;
					cnt++;
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		System.out.println(cnt + "\n" + max);
	}
	
	private static int bfs(int Y, int X) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {Y, X});
		final int[] dy = {0,0,-1,1}, dx = {1,-1,0,0};
		
		int ret = 0;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int y = cur[0], x = cur[1];
			ret++;
			for(int i=0 ; i<4 ; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx] || picture[ny][nx] == 0) {
					continue;
				}
				visit[ny][nx] = true;
				que.add(new int[] {ny, nx});
			}
		}
		return ret;
	}
}
