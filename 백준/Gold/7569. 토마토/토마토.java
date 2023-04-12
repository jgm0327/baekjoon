import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int n, m, H, zeroCount = 0, answer = 0;
	private static int[][][] boxes;
	private static Queue<int[]> tomatoPos;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[1]);
		m = Integer.parseInt(size[0]);
		H = Integer.parseInt(size[2]);
		boxes = new int[n][m][H];
		tomatoPos = new LinkedList<int[]>();
		
		for(int k=0 ; k<H ; k++) {
			for(int i=0 ; i < n ; i++) {
				String[] values = br.readLine().split(" ");
				for(int j=0 ; j<m ; j++) {
					int value = Integer.parseInt(values[j]);
					boxes[i][j][k] = value;
					if(value == 1)tomatoPos.add(new int[] {i, j, k, 0});
					else if(value == 0)zeroCount++;
				}
			}
		}
		
		bfs();
		System.out.println(zeroCount == 0 ? answer : -1);
		br.close();
	}

	private static void bfs() {
		final int[] dh = {1, -1, 0, 0, 0, 0}, dy = {0, 0, 0, 0, -1, 1}, dx = {0, 0, 1, -1, 0, 0};
		
		while(!tomatoPos.isEmpty()) {
			int[] pos = tomatoPos.poll();
			int y = pos[0], x = pos[1], h = pos[2], cnt = pos[3];
			
			for(int i=0 ; i<6 ; i++) {
				int nh = h + dh[i], ny = y + dy[i], nx = x + dx[i];
				if((0 <= ny && ny < n) && (0 <= nx && nx < m) && (0 <= nh && nh < H) && boxes[ny][nx][nh] == 0) {
					if(--zeroCount == 0) {
						answer = cnt + 1;
						return;
					}
					tomatoPos.add(new int[] {ny, nx, nh, cnt + 1});
					boxes[ny][nx][nh] = 1;
				}
			}
		}
	}
}
