import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	private static int n, m;
	private static int[][] ocean;
	private static List<int[]> sharks; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		m = Integer.parseInt(size[1]);
		sharks = new ArrayList<>();
		ocean = new int[n][m];
		
		for(int i=0 ; i<n ; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<m ; j++) {
				ocean[i][j] = Integer.parseInt(input[j]);
				if(ocean[i][j] == 1) {
					sharks.add(new int[] {i, j});
				}
			}
		}
		
		solution();
		br.close();
	}
	
	private static void solution() {
		int answer = 0;
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(ocean[i][j] != 1) {
					answer = Math.max(distance(i, j), answer);
				}
			}
		}
		System.out.println(answer);
	}
	
	private static int distance(int y, int x) {
		final int[] dy = {1, 1, -1, -1, 0, 1, 0, -1}, dx = {1, -1, -1, 1, 1, 0, -1, 0};
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visit = new boolean[n][m];
		que.add(new int[] {y, x, 0});
		
		while(!que.isEmpty()) {
			int[] pos = que.poll();
			int cy = pos[0], cx = pos[1], cnt = pos[2];
			for(int i=0 ; i<8 ; i++) {
				int ny = cy + dy[i], nx = cx + dx[i];
				if((0 <= ny && ny < n) && (0 <= nx && nx < m) && !visit[ny][nx]) {
					if(ocean[ny][nx] == 1) {
						return cnt + 1;
					}
					que.add(new int[] {ny, nx, cnt + 1});
					visit[ny][nx] = true;
				}
			}
		}
		return -1;
	}
}
