import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	private static int n;
	private static List<Integer>[] graph;
	private final static int INF = 1000000;
	private static int[] costs;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		graph = new ArrayList[n+1];
		for(int i=0 ; i<=n ; i++)graph[i] = new ArrayList<>();
		
		for(int i=0 ; i < Integer.parseInt(str[1]) ; i++) {
			String[] input = br.readLine().split(" ");
			int sour = Integer.parseInt(input[0]);
			int des = Integer.parseInt(input[1]);
			graph[sour].add(des);
			graph[des].add(sour);
		}
		
		int comp = INF, answer = 1;
		for(int i=1; i<=n ; i++) {
			bfs(i);
			int value = min();
			if(value < comp) {
				comp = value;
				answer = i;
			}
		}
		System.out.println(answer);
		br.close();
	}
	
	private static void bfs(int start) {
		costs = new int[n+1];
		Arrays.fill(costs, INF);
		costs[start] = 0;
		
		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		pq.add(new int[] {0, start});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int sour = cur[1], cost = cur[0];
			if(cost > costs[sour])continue;
			for(int des : graph[sour]) {
				int nextCost = cost + 1;
				if(costs[des] > nextCost) {
					costs[des] = nextCost;
					pq.add(new int[] {nextCost, des});
				}
			}
		}
	}
	
	private static int min() {
		int ret = 0;
		for(int i=1 ; i<=n ; i++) {
			ret += costs[i];
		}
		return ret;
	}
}
