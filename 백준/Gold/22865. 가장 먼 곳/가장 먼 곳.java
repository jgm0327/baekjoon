import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	private static List<int[]>[] graph;
	private static int[] friends;
	private static int[][] costs;
	private static int n, INF = 100000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		String[] str = br.readLine().split(" ");
		friends = new int[3];
		for(int i=0 ; i<3 ; i++)friends[i] = Integer.parseInt(str[i]);
		
		graph = new ArrayList[n+1];
		for(int i=0 ; i<=n ; i++)graph[i] = new ArrayList<>();
		
		int m = Integer.parseInt(br.readLine());
		for(int i=0 ; i<m ; i++) {
			String[] input = br.readLine().split(" ");
			int sour = Integer.parseInt(input[0]);
			int des = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			graph[sour].add(new int[] {des, weight});
			graph[des].add(new int[] {sour, weight});
		}

		costs = new int[3][n+1];
		for(int i=0 ; i<3 ; i++) {
			dikjstra(i, friends[i]);
		}
		
		int answer = 1, prev = 0;
		for(int i=1 ; i<=n ; i++) {
			int tmp = INF;
			for(int j=0 ; j<3 ;j++) {
				if(tmp > costs[j][i]) {
					tmp = costs[j][i];
				}
			}
			if(prev < tmp) {
				prev = tmp;
				answer = i;
			}
		}
		
		System.out.println(answer);
		br.close();
	}
	
	private static void dikjstra(int idx, int start) {
		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		Arrays.fill(costs[idx], INF);
		costs[idx][start] = 0;
		pq.add(new int[] {0, start});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int sour = cur[1], cost = cur[0];
			if(cost > costs[idx][sour])continue;
			
			for(int[] next : graph[sour]) {
				int des = next[0], weight = next[1];
				int nextCost = weight + cost;
				if(nextCost < costs[idx][des]) {
					costs[idx][des] = nextCost;
					pq.add(new int[] {nextCost, des});
				}
			}
		}
	}
}
