
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	private static int n, cnt;
	private static char[][] graph;
	private static Queue<Integer> answer;
	private static boolean[][] visit;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new char[n][n];
		
		for(int i=0 ; i<n ; i++) {
			String str = br.readLine();
			for(int j=0 ; j<n ; j++) {
				graph[i][j] = str.charAt(j);
			}
		}
		visit = new boolean[n][n];
		answer = new PriorityQueue<>();
		br.close();
	}
	private static void solution() throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(!visit[i][j] && graph[i][j] == '1') {
					cnt++;
					bfs(i, j);
				}
			}
		}
		
		bw.write(cnt+"");
		bw.write("\n");
		while(!answer.isEmpty()) {
			bw.write(answer.poll()+"");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	private static void bfs(int Y, int X) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {Y, X});
		visit[Y][X] = true;
		final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
		int total = 0;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			total++;
			int y = cur[0], x = cur[1];
			for(int i=0 ; i<4 ; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if(0 > ny || ny >= n || 0 > nx || nx >= n || visit[ny][nx] || graph[ny][nx] == '0')continue;
				que.add(new int[] {ny, nx});
				visit[ny][nx] = true;
			}
		}
		answer.add(total);
	}
}
