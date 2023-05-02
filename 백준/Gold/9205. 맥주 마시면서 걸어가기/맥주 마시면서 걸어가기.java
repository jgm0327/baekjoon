import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
	private static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public Point(String[] str) {
			this.y = Integer.parseInt(str[0]);
			this.x = Integer.parseInt(str[1]);
		}
	}

	private static int n;
	private static Point start, end;
	private static Point[] conveniences;

	public static void main(String[] args) throws IOException {
		input();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());

			start = new Point(br.readLine().split(" "));

			conveniences = new Point[n + 1];
			for (int i = 0; i < n; i++) {
				conveniences[i] = new Point(br.readLine().split(" "));
			}

			end = new Point(br.readLine().split(" "));
			bw.write(solution());
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static String solution() {
		if(Math.abs(start.y - end.y) + Math.abs(start.x - end.x) <= 1000)return "happy\n";
		Queue<Point> que = new LinkedList<>();
		Map<Object, Boolean> visit = new HashMap<>();
		visit.put(start, true);
		que.add(start);
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			for(int i=0 ; i<n ; i++) {
				Point next = conveniences[i];
				int curToConvenience = Math.abs(cur.y - next.y) + Math.abs(cur.x - next.x);
				if(visit.containsKey(next) || curToConvenience > 1000)continue;
				int nextToEnd = Math.abs(next.y - end.y) + Math.abs(next.x - end.x);
				if(nextToEnd <= 1000)return "happy\n";
				que.add(next);
				visit.put(next, true);
			}
		}
		return "sad\n";
	}

}
