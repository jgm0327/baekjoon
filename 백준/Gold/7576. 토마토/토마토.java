import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int n, m;
	static int zero_cnt = 0;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
			n = arr[1]; m = arr[0];
			int[][] graph = new int[n][m];
			Queue<Integer[]> pos = new LinkedList<>();
			for(int i=0 ; i<n ; i++) {
				Integer[] col = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
				for(int j=0 ; j<m ; j++) {
					graph[i][j] = col[j];
					if(col[j] == 1)pos.add(new Integer[] {i, j, 0});
					else if(col[j] == 0)zero_cnt++;
				}
			}
			System.out.println(bfs(pos, graph));
		}catch(IOException e) {
			
		}
	}
	
	private static int bfs(Queue<Integer[]> que, int[][] graph) {
		if(zero_cnt == 0)return 0;
		int[] dy = {1,-1,0,0}, dx = {0,0,-1,1};
		boolean[][] visit = new boolean[n][m];
		while(!que.isEmpty()) {
			Integer[] arr = que.poll();
			int y = arr[0], x = arr[1], cnt = arr[2];
			for(int i=0 ; i<4 ; i++) {
				int nextY = dy[i] + y, nextX = dx[i] + x;
				if((0 <= nextY && nextY < n) && (0 <= nextX && nextX < m) && !visit[nextY][nextX] && graph[nextY][nextX] == 0) {
					zero_cnt--;
					if(zero_cnt == 0)return cnt + 1;
					que.add(new Integer[] {nextY, nextX, cnt + 1});
					visit[nextY][nextX] = true;
				}
			}
		}
		return -1;
	}
}
