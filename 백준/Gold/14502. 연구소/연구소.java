import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	private static int n, m, zero_cnt = -3, answer = 0;
	private static List<int[]> virus, zero;
	private static int[][] graph;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
			n = arr[0]; m = arr[1];
			graph = new int[n][m];
			virus = new ArrayList<int[]>();
			zero = new ArrayList<int[]>();
			for(int i=0 ; i<n ; i++) {
				Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
				for(int j=0 ; j<m ; j++) {
					graph[i][j] = input[j];
					if(input[j] == 2)virus.add(new int[] {i, j});
					else if(input[j] == 0) {
						zero.add(new int[] {i, j});
						zero_cnt++;
					}
				}
			}
			if(zero_cnt == -3)System.out.println(0);
			else {
				recur(0);
				System.out.println(answer);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void bfs() {
		Queue<int[]> que = new LinkedList<int[]>();
		for(int[] v : virus) que.add(v);
		boolean[][] visit = new boolean[n][m];
		int[] s = que.peek();
		int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
		int tmp = zero_cnt;
		visit[s[0]][s[1]] = true;
		while(!que.isEmpty() && tmp > -3) {
			int[] cur = que.poll();
			int y = cur[0], x = cur[1];
			for(int i = 0; i <4 ; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if(0 <= ny && ny < n && 0 <= nx && nx < m && !visit[ny][nx] && graph[ny][nx] == 0) {
					que.add(new int[] {ny, nx});
					tmp--;
					visit[ny][nx] = true;
					if(tmp < answer)return;
				}
			}
		}
		answer = tmp;
	}
	
	private static void recur(int depth) {
		if(depth == 3) {
			bfs();
			return;
		}
		for(int[] pos : zero) {
			int y = pos[0], x = pos[1];
			if(graph[y][x] == 0) {
				graph[y][x] = 1;
				recur(depth+1);
				graph[y][x] = 0;
			}
		}
	}
}
