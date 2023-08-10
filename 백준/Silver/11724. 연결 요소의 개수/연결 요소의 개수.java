import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static List<Integer>[] graph;
	private static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		graph = new ArrayList[n + 1];
		for(int i=0 ; i<=n ; i++){
			graph[i] = new ArrayList<>();
		}

		for(int i=0 ; i<m ; i++){
			stk = new StringTokenizer(br.readLine());
			int sour = Integer.parseInt(stk.nextToken()), des = Integer.parseInt(stk.nextToken());
			graph[sour].add(des);
			graph[des].add(sour);
		}

		visit = new boolean[n + 1];
		int answer = 0;
		for(int i=1; i <=n ; i++){
			if(visit[i])continue;
			dfs(i);
			answer++;
		}
		System.out.println(answer);

		br.close();
	}

	private static void dfs(int sour){
		visit[sour] = true;
		for(int des : graph[sour]){
			if(visit[des])continue;
			dfs(des);
		}
	}
}
