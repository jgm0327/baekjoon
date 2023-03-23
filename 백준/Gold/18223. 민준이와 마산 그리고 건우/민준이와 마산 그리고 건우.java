import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	private static int n, m;
	private static List<Integer[]>[] graph;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			int e = Integer.parseInt(str[2]);
			
			graph = new ArrayList[n+1];
			for(int i=0 ; i<n+1 ; i++)graph[i] = new ArrayList<>();
			
			for(int i=0 ; i<m ; i++) {
				String[] input = br.readLine().split(" ");
				int sour = Integer.parseInt(input[0]);
				int des = Integer.parseInt(input[1]);
				int weight = Integer.parseInt(input[2]);
				graph[sour].add(new Integer[] {des, weight});
				graph[des].add(new Integer[] {sour, weight});
			}
			int n1 = dikjstra(1, e), n2 = dikjstra(e, n), n3 = dikjstra(1, n);
			System.out.println(n1 + n2 <= n3 ? "SAVE HIM" : "GOOD BYE");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int dikjstra(int s, int e) {
		Queue<Integer[]> pq = new PriorityQueue<Integer[]>((o1, o2) -> o1[0] - o2[0]);
		Integer[] costs = new Integer[n+1];
		int INF = 1000000000;
		Arrays.fill(costs, INF);
		costs[s] = 0;
		pq.add(new Integer[] {0, s});
		
		while(!pq.isEmpty()) {
			Integer[] cur = pq.poll();
			int sour = cur[1], cost = cur[0];
			if(cost > costs[sour])continue;
			for(Integer[] v : graph[sour]) {
				int des = v[0], w = v[1];
				int next_cost = w + cost;
				if(costs[des] > next_cost) {
					costs[des] = next_cost;
					pq.add(new Integer[] {costs[des], des});
				}
			}
		}
		return costs[e];
	}
}
