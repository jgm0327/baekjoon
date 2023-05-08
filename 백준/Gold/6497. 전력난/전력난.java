
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	private static int n, m, total;
	private static Queue<int[]> pq;
	private static int[] parents;
	
	public static void main(String[] args) throws IOException{
		solution();
	}
	
	private static void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String[] size = br.readLine().split(" ");
			n = Integer.parseInt(size[0]);
			m = Integer.parseInt(size[1]);
			if(n == 0 && m == 0)break;
			
			pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
			parents = new int[n+1];
			for(int i=0 ; i<=n ; i++)parents[i] = i;
			
			total = 0;
			for(int i=0 ; i<m ; i++) {
				String[] str = br.readLine().split(" ");
				int sour = Integer.parseInt(str[0]), des = Integer.parseInt(str[1]);
				if(sour == 0 && des == 0) {
					br.close();
					return;
				}
				int cost = Integer.parseInt(str[2]);
				total += cost;
				pq.add(new int[] {sour, des, cost});
			}
			mst();
			bw.write(total + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int findParent(int x) {
		if(parents[x] == x)return x;
		return parents[x] = findParent(parents[x]);
	}
	
	private static void union(int x, int y) {
		int nx = findParent(x), ny = findParent(y);
		if(nx == ny)return;
		parents[nx] = ny;
	}
	
	private static void mst() {
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int sour = cur[0], des = cur[1], cost = cur[2];
			if(findParent(sour) == findParent(des))continue;
			union(sour, des);
			total -= cost;
		}
	}
}
