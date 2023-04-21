import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	private static int n, k, blackCnt = 0, answer = Integer.MAX_VALUE;
	private static int[][] lab;
	private static final int[] dy = {0,0,-1,1}, dx = {1,-1,0,0};
	private static List<int[]> virus;
	
	public static void main(String[] args) throws IOException{
		init();
		if(blackCnt == 0)answer = 0;
		else activateVirus(0, 0, new ArrayDeque<>());
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		k = Integer.parseInt(size[1]);
		lab = new int[n][n];
		virus = new ArrayList<>();
		
		for(int i=0 ; i<n ; i++) {
			String[] values = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++) {
				int[] pos = new int[] {i, j};
				lab[i][j] = Integer.parseInt(values[j]);
				if(lab[i][j] == 2)virus.add(pos);
				else if(lab[i][j] == 0)blackCnt++;
			}
		}
		br.close();
	}
	
	private static void activateVirus(int depth, int start, Deque<int[]> deque) {
		if(depth == k) {
			answer = Math.min(answer, spread(deque));
			return;
		}
		
		for(int i=start ; i<virus.size() ; i++) {
			int[] pos = virus.get(i);
			int y = pos[0], x = pos[1];
			deque.add(new int[] {y, x, 0});
			activateVirus(depth + 1, i + 1, deque);
			deque.pollLast();
		}
	}
	
	private static int spread(Deque<int[]> deque) {
		Queue<int[]> que = new LinkedList<>();
		que.addAll(deque);
		boolean[][] visit = new boolean[n][n];
		int tmp = blackCnt;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int y = cur[0], x = cur[1], cnt = cur[2];
			visit[y][x] = true;
			for(int i=0 ; i<4 ; i++) {
				int ny = y + dy[i], nx = x + dx[i], nCnt = cnt + 1;
				if((0 <= ny && ny < n) && (0 <= nx && nx < n) && !visit[ny][nx] && lab[ny][nx] != 1) {
					visit[ny][nx] = true;
					que.add(new int[] {ny, nx, nCnt});
					if(lab[ny][nx] == 0)tmp--;
					if(tmp == 0)return nCnt;
				}
			}
		}
		return answer;
	}
}
