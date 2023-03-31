import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		long start = Long.parseLong(str[0]);
		
		long target = Long.parseLong(str[1]);
		System.out.println(bfs(start, target));
		br.close();
	}
	
	private static long bfs(long start, long target) {
		Queue<long[]> que = new LinkedList<>();
		Map<Long, Boolean> visit = new HashMap<>();
		que.add(new long[] {start, 1L});
		visit.put(start, true);
		if(start == target)return 1;
		
		while(!que.isEmpty()) {
			long[] cur = que.poll();
			long x = cur[0], cnt = cur[1];
			long twoTimes = x * 2, endOne = Long.parseLong(x + "1");
			
			if(twoTimes == target || endOne == target)return cnt + 1;
			
			if(target > twoTimes && !visit.containsKey(twoTimes)) {
				que.add(new long[] {twoTimes, cnt+1});
				visit.put(twoTimes, true);
			}
			if(target > endOne && !visit.containsKey(endOne)) {
				que.add(new long[] {endOne, cnt+1});
				visit.put(endOne, true);
			}
		}
		return -1;
	}
}
