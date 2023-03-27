import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] graph;
	private static List<Integer> order;
	private static Queue<Integer> que;
	private static int[] degree;
	private static boolean[] visit;
	private static int n, m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		degree = new int[n+1];
		visit = new boolean[n+1];
		que = new LinkedList<>();
		order = new ArrayList<>();
		graph = new ArrayList[n+1];
		for(int i=0 ; i<=n ; i++)graph[i] = new ArrayList<>();
		
		for(int i=0 ; i<m ; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(stk.nextToken());
			int prev = Integer.parseInt(stk.nextToken());
			while(stk.hasMoreTokens()) {
				int next = Integer.parseInt(stk.nextToken());
				graph[prev].add(next);
				degree[next]++;
				prev = next;
			}
		}
		boolean flag = true;
		while(flag) {
			flag = false;
			for(int i=1; i <=n ; i++) {
				if(degree[i] == 0 && !visit[i]) {
					visit[i] = true;
					que.add(i);
					flag = true;
					order.add(i);
				}
			}
			topology_sort();
		}
		if(order.size() != n)System.out.println(0);
		else {
			for(int data : order) {
				bw.write(data + "\n");
			}
		}
		bw.close();
		br.close();
	}
	
	private static void topology_sort() {
		while(!que.isEmpty()) {
			int cur = que.poll();
			for(int des : graph[cur]) {
				degree[des]--;
				if(degree[des] == 0 && !visit[des]) {
					visit[des] = true;
					que.add(des);
					order.add(des);
				}
			}
		}
	}
}
