import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	private static int n, answer = 1;
	private static boolean brighten;
	private static List<int[]>[][] graph;
	private static boolean[][] rooms, isBrighten;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		rooms = new boolean[n + 1][n + 1];
		
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		rooms = new boolean[n+1][n+1];
		isBrighten = new boolean[n+1][n+1];
		
		graph = new ArrayList[n+1][n+1];
		for(int i=0 ; i<=n ; i++) {
			graph[i] = new ArrayList[n+1];
			for(int j=0 ; j<=n ; j++) {
				graph[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0 ; i<Integer.parseInt(size[1]) ; i++) {
			String[] values = br.readLine().split(" ");
			int sourY = Integer.parseInt(values[0]), sourX = Integer.parseInt(values[1]);
			int desY = Integer.parseInt(values[2]), desX = Integer.parseInt(values[3]);
			graph[sourY][sourX].add(new int[] {desY, desX});
		}
		
		rooms[1][1] = true;
		brighten = true;
		while(brighten) {
			brighten = false;
			answer = Math.max(bfs(), answer);
		}
		System.out.println(answer);
		br.close();
	}
	
	private static int bfs() {
		int ret = 1;
		Queue<int[]> que = new LinkedList<>();
		final int[] dy = {0,0,-1,1}, dx = {1,-1,0,0};
		
		boolean[][] visit = new boolean[n+1][n+1];
		
		boolean[][] isOn = new boolean[n+1][n+1];
		que.add(new int[] {1, 1});
		visit[1][1] = true;
		isOn[1][1] = true;
		
		while(!que.isEmpty()) {
			int[] pos = que.poll();
			int y = pos[0], x = pos[1];
			if(!isBrighten[y][x]) {
				brighten = isBrighten[y][x] = true;
			}
			ret += lightOn(y, x, isOn);
			
			for(int i=0 ; i<4 ; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if((1 <= ny && ny <= n) && (1 <= nx && nx <= n) && !visit[ny][nx] && rooms[ny][nx]) {
					visit[ny][nx] = true;
					que.add(new int[] {ny, nx});
				}
			}
		}
		return ret;
	}
	
	private static int lightOn(int y, int x, boolean[][] isOn) {
		int cnt = 0;
		for(int[] pos : graph[y][x]) {
			int ny = pos[0], nx = pos[1];
			if(!isOn[ny][nx]) {
				isOn[ny][nx] =  true;
				cnt++;
			}
			rooms[ny][nx] = true;
		}
		return cnt;
	}
}
