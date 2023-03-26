import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n, m, k;
	private static List<int[]>[] graph;
	private static List<Integer> friends;
	private static int[][] costs;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int T = Integer.parseInt(br.readLine());
			while(T-- > 0) {
				String[] str = br.readLine().split(" ");
				n = Integer.parseInt(str[0]);
				m = Integer.parseInt(str[1]);
				graph = new ArrayList[n+1];
				friends = new ArrayList<Integer>();
				costs = new int[n+1][n+1];
				
				for(int i=0 ; i<=n ; i++) {
					graph[i] = new ArrayList<int[]>();
					Arrays.fill(costs[i], 100000000);
				}
				
				
				for(int i=0 ; i<m ; i++) {
					StringTokenizer stk = new StringTokenizer(br.readLine());
					int sour = Integer.parseInt(stk.nextToken());
					int des = Integer.parseInt(stk.nextToken());
					int weight = Integer.parseInt(stk.nextToken());
					graph[sour].add(new int[] {des, weight});
					graph[des].add(new int[] {sour, weight});
				}
				
				k = Integer.parseInt(br.readLine());
				str = br.readLine().split(" ");
				for(int i=0 ; i<k ; i++) {
					friends.add(Integer.parseInt(str[i]));
				}
				
				for(int friend : friends) {
					dikjstra(friend);
				}
				
				int comp = 100000000, answer = 1;
				for(int i=1; i<=n ; i++) {
					int temp = 0;
					for(int friend : friends) {
						temp += costs[friend][i];
					}
					if(temp < comp) {
						comp = temp;
						answer = i;
					}
				}
				bw.write(answer + "\n");
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void dikjstra(int start) {
		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		costs[start][start] = 0;
		pq.add(new int[] {0, start});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int sour = cur[1], cost = cur[0];
			if(costs[start][sour] < cost)continue;
			
			for(int[] g : graph[sour]) {
				int des = g[0], weight = g[1];
				int nextCost = cost + weight;
				if(nextCost < costs[start][des]) {
					costs[start][des] = nextCost;
					pq.add(new int[] {nextCost, des});
				}
			}
		}
	}
}
