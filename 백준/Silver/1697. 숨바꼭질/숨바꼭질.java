import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	private static int n, m;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
			n = arr[0]; m = arr[1];
			int answer = Math.abs(n - m);
			
			System.out.print(Math.min(bfs(), answer));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int bfs() {
		Queue<Integer[]> que = new LinkedList<>();
		boolean[] visit = new boolean[200001];
		int[] dx = {2, 1, -1};
		que.add(new Integer[] {n, 0});
		while(!que.isEmpty()) {
			Integer[] arr = que.poll();
			int cur = arr[0], cnt = arr[1];
			for(int i=0 ; i<3 ; i++) {
				int value = cur + dx[i];
				if(i == 0) value = cur * dx[i];
				if(value >= 0 && value < 200000 && !visit[value]) {
					if(value == m)return cnt + 1;
					que.add(new Integer[] {value, cnt + 1});
					visit[value] = true;
					}
				}
			}
		return 0;
	}
}
