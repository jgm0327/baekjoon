import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
	public class Main {
		private static int n, m;
		private static char[][] graph;
		public static void main(String[] args) throws IOException{
			init();
			System.out.println(solution());
		}
		
		private static void init() throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] size = br.readLine().split(" ");
			n = Integer.parseInt(size[0]);
			m = Integer.parseInt(size[1]);
			graph = new char[n][m];
			
			for(int i=0 ; i<n ; i++) {
				String values = br.readLine();
				for(int j=0 ; j<m ; j++) {
					graph[i][j] = values.charAt(j);
				}
			}
			
			br.close();
		}
		
		private static int solution() {
			int answer = 0;
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<m ; j++) {
					if(graph[i][j] == 'L') {
						answer = Math.max(answer, bfs(i, j));
					}
				}
			}
			return answer;
		}
		
		private static int bfs(int Y, int X) {
			Queue<int[]> que = new LinkedList<int[]>();
			que.add(new int[] {Y, X, 0});
			boolean[][] visit = new boolean[n][m];
			final int[] dy = {0,0,-1,1}, dx = {1,-1,0,0};
			visit[Y][X] = true;
			
			int ret = 0;
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				int y = cur[0], x = cur[1], cnt = cur[2];
				for(int i=0 ; i<4 ; i++) {
					int ny = y + dy[i], nx = x + dx[i];
					if(0 <= ny && ny < n && 0 <= nx && nx < m && !visit[ny][nx] && graph[ny][nx] == 'L') {
						visit[ny][nx] = true;
						que.add(new int[] {ny, nx, cnt+1});
						ret = Math.max(ret, cnt+1);
					}
				}
			}
			return ret;
		}
		
}
