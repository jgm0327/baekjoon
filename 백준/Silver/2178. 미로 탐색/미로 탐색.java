import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
			int[][] graph = new int[n][m];
			for(int i=0 ; i<n ; i++) {
				String[] tmp = br.readLine().split("");
				for(int j=0 ; j<m ; j++) {
					graph[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			int answer = bfs(n, m, graph);
			System.out.print(answer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int bfs(int n, int m, int[][] graph) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {0, 0, 1});
		int[] dy = {0,0,-1,1}, dx = {1,-1,0,0};
		boolean[][] visit = new boolean[n][m];
		visit[0][0] = true;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int y = cur[0], x = cur[1], cnt = cur[2];
			for(int i=0 ; i<4 ; i++) {
				int ny = dy[i] + y, nx = dx[i] + x;
				if((0 <= ny && ny < n) && (0 <= nx && nx < m) && !visit[ny][nx] && graph[ny][nx] == 1) {
					if(ny == n - 1 && nx == m - 1)return cnt + 1;
					visit[ny][nx] = true;
					que.add(new int[] {ny, nx, cnt + 1});
				}
			}
		}
		return 0;
	}
}
