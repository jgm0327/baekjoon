import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	private static int n;
	private static int[] parents;
	private static Queue<int[]> pq;
	
	public static void main(String[] args) throws IOException{
		init();
		solution();
	}
	
	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		
		parents = new int[n+1];
		for(int i=0 ; i<=n ; i++)parents[i] = i;
		
		int m = Integer.parseInt(size[1]);
		
		pq = new PriorityQueue<>((o1,o2) -> o1[2] - o2[2]);
		
		while(m-- > 0) {
			String[] str = br.readLine().split(" ");
			int sour = Integer.parseInt(str[0]), des = Integer.parseInt(str[1]), cost = Integer.parseInt(str[2]);
			pq.add(new int[] {sour, des, cost});
		}
		br.close();
	}
	
	private static int findParent(int x) {
		if(x == parents[x])return x;
		return parents[x] = findParent(parents[x]);
	}
	
	private static void union(int x, int y) {
		int nx = findParent(x), ny = findParent(y);
		if(nx == ny)return;
		parents[ny] = nx;
	}
	
	private static void solution() {
		int ret = 0, cost = 0;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int sour = cur[0], des = cur[1];
			if(findParent(sour) == findParent(des))continue;
			cost = cur[2];
			union(sour, des);
			ret += cost;
		}
		ret -= cost;
		System.out.println(ret);
	}
}
