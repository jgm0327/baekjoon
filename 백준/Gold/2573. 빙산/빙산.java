import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Point{
		public int y, x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	private static int n, m;
	private static Queue<Point> ice;
	private static boolean[][] visit;
	private static int[][] ocean;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		m = Integer.parseInt(size[1]);
		ice = new LinkedList<>();
		ocean = new int[n][m];
		
		for(int i=0 ; i<n ; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0 ;j<m ; j++) {
				ocean[i][j] = Integer.parseInt(input[j]);
				if(ocean[i][j] != 0)ice.add(new Point(i, j));
			}
		}
		
		int answer = 0;
		while(true) {
			answer++;
			melting();
			if(seperate() || ice.isEmpty())
				break;
		}
		System.out.println(ice.size() == 0 ? 0 : answer);
		br.close();
	}
	
	private static boolean seperate() {
		int cnt = 0;
		visit = new boolean[n][m];
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ;j<m ; j++) {
				if(!visit[i][j] && ocean[i][j] != 0) {
					if(cnt == 1)return true;
					bfs(i, j);
					cnt++;
				}
			}
		}
		return false;
	}
	
	private static void melting() {
		int[] dy = {0,0,-1,1}, dx = {1,-1,0,0};
		int len = ice.size();
		boolean[][] v = new boolean[n][m];
		
		for(int i=0 ; i < len ; i++) {
			Point point = ice.poll();
			int y = point.y, x = point.x;
			
			for(int j=0 ; j<4 ; j++) {
				int ny = y + dy[j], nx = x + dx[j];
				if((0 <= ny && ny < n && 0 <= nx && nx < m) && !v[ny][nx] && ocean[ny][nx] == 0) {
					ocean[y][x]--;
				}
			}
			
			if(ocean[y][x] <= 0) {
				ocean[y][x] = 0;
				v[y][x] = true;
				continue;
			}
			ice.offer(point);
		}
	}
	
	private static void bfs(int y, int x) {
		int[] dy = {0,0,-1,1}, dx = {1,-1,0,0};
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(y, x));
		visit[y][x] = true;
		
		while(!que.isEmpty()) {
			Point point = que.poll();
			int cy = point.y, cx = point.x;
			for(int j=0 ; j<4 ; j++) {
				int ny = cy + dy[j], nx = cx + dx[j];
				if((0 <= ny && ny < n && 0 <= nx && nx < m) && !visit[ny][nx] && ocean[ny][nx] != 0) {
					visit[ny][nx] = true;
					que.add(new Point(ny, nx));
				}
			}
		}
	}
}
