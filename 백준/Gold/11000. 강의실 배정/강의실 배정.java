import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	private static int n;
	private static Lecture[] lectures;
	
	static class Lecture implements Comparable<Lecture>{
		int start, end;
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Lecture o) {
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		lectures = new Lecture[n];
		for(int i=0 ; i<n ; i++) {
			String[] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]), end = Integer.parseInt(str[1]);
			lectures[i] = new Lecture(start, end);
		}
		System.out.println(solution());
		br.close();
	}
	
	private static int solution() {
		Queue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(lectures);
		pq.add(lectures[0].end);
		for(int i=1; i<n ; i++) {
			if(pq.peek() <= lectures[i].start) {
				pq.poll();
			}
			pq.add(lectures[i].end);
		}
		return pq.size();
	}
}
