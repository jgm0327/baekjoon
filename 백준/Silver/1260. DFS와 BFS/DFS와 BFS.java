import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int n, m;
	static boolean[] visit;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Integer[] arr = (Integer[])Arrays.stream(br.readLine().split(" "))
					.map(Integer::parseInt)
					.toArray(Integer[]::new);
			n = arr[0]; 
			m = arr[1]; 
			int s = arr[2];
			ArrayList<Integer>[] graph = new ArrayList[n+1];
			for(int i=0 ; i<n+1 ; i++) {
				graph[i] = new ArrayList<>();
			}
			for(int i=0 ; i<m ; i++) {
				Integer[] input = (Integer[])Arrays.stream(br.readLine().split(" "))
						.map(Integer::parseInt)
						.toArray(Integer[]::new);
				graph[input[0]].add(input[1]);
				graph[input[1]].add(input[0]);
			}
			visit = new boolean[n+1];
			dfs(s, graph);
			System.out.println();
			visit = new boolean[n+1];
			bfs(s, graph);
		}catch(IOException e) {
			
		}
	}
	
	public static void bfs(int s, ArrayList<Integer>[] graph) {
		Queue<Integer> que = new LinkedList<>();
		que.add(s);
		visit[s] = true;
		while(!que.isEmpty()) {
			int sour = que.poll();
			System.out.print(sour + " ");
			Collections.sort(graph[sour]);
			graph[sour].stream()
			.filter(des -> !visit[des])
			.forEach(des ->{
				que.add(des);
				visit[des] = true;
			});
		}
	}
	
	public static void dfs(int sour, ArrayList<Integer>[] graph) {
		if(visit[sour])return;
		visit[sour] = true;
		System.out.print(sour + " ");
		Collections.sort(graph[sour]);
		for(Integer des : graph[sour]) {
			if(!visit[des])dfs(des, graph);
		}
	}

}
