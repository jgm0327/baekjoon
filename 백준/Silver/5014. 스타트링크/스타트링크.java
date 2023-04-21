import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int f, s, g, u, d;
	
	public static void main(String[] args) throws IOException{
		init();
		int answer = isReached();
		System.out.println(answer == -1 ? "use the stairs" : answer);
	}
	
	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		f = Integer.parseInt(size[0]);
		s = Integer.parseInt(size[1]);
		g = Integer.parseInt(size[2]);
		u = Integer.parseInt(size[3]);
		d = Integer.parseInt(size[4]);
		br.close();
	}
	
	private static int isReached() {
		if(s == g)return 0;
		Queue<int[]>que = new LinkedList<>();
		que.add(new int[] {s, 0});
		boolean[] visit = new boolean[f+1];
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int up = cur[0] + u, down = cur[0] - d;
			if(up == g || down == g)return cur[1] + 1;
			if(up <= f && !visit[up]) {
				que.add(new int[] {up, cur[1] + 1});
				visit[up] = true;
			}
			if(down >= 1 && !visit[down]) {
				que.add(new int[] {down, cur[1] + 1});
				visit[down] = true;
			}
		}
		return -1;
	}
}
