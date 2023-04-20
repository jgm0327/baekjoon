import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int n, fishCnt = 0, babySize = 2, eaten = 0;
	private static int[][] ocean;
	private static int[] start;
	private static final int[] dy = {0,0,1,-1}, dx = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException{
		insert();
		solution();
	}
	
	private static void insert() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ocean = new int[n][n];
		
		for(int i=0 ; i<n ; i++) {
			String[] values = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++) {
				int[] pos = new int[] {i, j};
				ocean[i][j] = Integer.parseInt(values[j]);
				if(ocean[i][j] == 9) {
					ocean[i][j] = 0;
					start = pos;
				}
				else if(ocean[i][j] != 0)fishCnt++;
			}
		}
		br.close();
	}
	
	private static void solution() {
		int ret = 0;
		while(fishCnt > 0) {
			int[] comp = bfs(start[0], start[1]);
			if(comp[0] == start[0] && comp[1] == start[1])break;
			fishCnt--;
			ocean[comp[0]][comp[1]] = 0;
			start = new int[] {comp[0], comp[1]};
			ret += comp[2];
			sizeUp();
		}
		System.out.println(ret);
	}
	
	private static void sizeUp() {
		if(++eaten == babySize) {
			babySize++;
			eaten = 0;
		}
	}
	
	private static boolean isIn(int y, int x) {
		return (0 <= y && y < n) && (0 <= x && x < n);
	}
	
	private static int[] bfs(int Y, int X) {
		int[] ret = new int[] {Y, X, Integer.MAX_VALUE};
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visit = new boolean[n][n];
		visit[Y][X] = true;
		que.add(new int[] {Y, X, 0});
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int y = cur[0], x = cur[1], cnt = cur[2];
			for(int i=0 ; i<4 ; i++) {
				int ny = y + dy[i], nx = x + dx[i], nCnt = cnt + 1;
				if(isIn(ny, nx) && !visit[ny][nx]) {
					if(ocean[ny][nx] > babySize)continue;
					visit[ny][nx] = true;
					if(ocean[ny][nx] != 0 && ocean[ny][nx] < babySize) {
						ret = compareDist(ret, new int[] {ny,  nx, nCnt});
					}else if(ocean[ny][nx] <= babySize){
						que.add(new int[] {ny, nx, nCnt});
					}
				}
			}
		}
		return ret;
	}
	
	private static int[] compareDist(final int[] cur, final int[] next) {
		int[] ret = new int[] {cur[0], cur[1], cur[2]};
		if(cur[2] > next[2])ret = next;
		else if(cur[2] == next[2]) {
			if(cur[0] > next[0])ret = next;
			else if(cur[0] == next[0] && cur[1] > next[1])ret = next;
		}
		return ret;
	}
}
