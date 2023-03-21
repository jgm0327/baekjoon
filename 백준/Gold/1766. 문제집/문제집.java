import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static List<Integer>[] graph;
	static int[] count;
	static Queue<Integer> que;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer strtk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(strtk.nextToken());
			m = Integer.parseInt(strtk.nextToken());
			count = new int[n+1];
			graph = new ArrayList[n+1];
			que = new PriorityQueue<>();
			for(int i=0 ; i<=n ; i++)graph[i] = new ArrayList<Integer>();
			for(int i=0 ; i<m ; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int sour = Integer.parseInt(tk.nextToken());
				int des = Integer.parseInt(tk.nextToken());
				graph[sour].add(des);
				count[des]++;
			}
			for(int i=1; i <=n ; i++) {
				if(count[i] == 0)que.add(i);
			}
			bfs();
			br.close();
		}catch(IOException e) {
			
		}
	}
	
	private static void bfs() {
		List<Integer> list = new ArrayList<>();
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			list.add(cur);
			for(int des : graph[cur]) {
				count[des]--;
				if(count[des] == 0)que.add(des);
			}
		}
		
		StringBuilder str = new StringBuilder();
		for(int value : list) {
			str.append(value + " ");
		}
		System.out.println(str.toString());
	}
}
