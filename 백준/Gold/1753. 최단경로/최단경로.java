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

public class Main {
	
	static int n, m;
	static List<Integer[]> graph[];
	static int[] costs;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
			n = arr[0]; m = arr[1];
			graph = new ArrayList[n+1];
			for(int i=1 ; i<=n ; i++)graph[i] = new ArrayList<>();
			int start = Integer.parseInt(br.readLine()), INF = 1000000000;
			
			for(int i=0 ; i<m ; i++) {
				Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
				int sour = input[0], des = input[1], weight = input[2];
				graph[sour].add(new Integer[] {des, weight});
			}
			
			costs = new int[n + 1];
			Arrays.fill(costs, INF);
			dijkstra(start);
			StringBuilder str = new StringBuilder();
			for(int i=1 ; i<=n ; i++) {
				str.append(costs[i] != INF ? costs[i] + "\n" : "INF\n");
			}
			bw.write(str.toString());
			br.close();
			bw.close();
		}catch(IOException e) {
			
		}
	}
	
	private static void dijkstra(int start) {
		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		pq.add(new int[] {0, start});
		costs[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cost = cur[0], sour = cur[1];
			if(costs[sour] < cost)continue;
			for(Integer[] data : graph[sour]) {
				int des = data[0], next_cost = cost + data[1];
				if(next_cost < costs[des]) {
					costs[des] = next_cost;
					pq.add(new int[] {costs[des], des});
				}
			}
		}
	}
}
