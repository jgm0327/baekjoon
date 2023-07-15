import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

	private static int n, cnt, countries;
	private static boolean flag;
	private static List<Integer>[] graph;
	private static boolean[] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();

		while(T-- > 0){
			String[] size = br.readLine().split(" ");
			n = Integer.parseInt(size[0]);
			int m = Integer.parseInt(size[1]);
			graph = new ArrayList[n+1];
			visit = new boolean[n+1];

			for(int i=0 ; i<=n ; i++)
				graph[i] = new ArrayList<>();

			for(int i=0 ; i<m ; i++){
				String[] str = br.readLine().split(" ");
				int sour = Integer.parseInt(str[0]), des = Integer.parseInt(str[1]);
				graph[sour].add(des);
				graph[des].add(sour);
			}
			cnt = 0;
			countries = 1;
			flag = false;
			dfs(1, 0);
			answer.append(cnt);
			answer.append("\n");
		}
		System.out.print(answer);
	}

	private static void dfs(int sour, int depth){
		if(countries == n){
			flag = true;
			return;
		}
		visit[sour] = true;
		cnt++;
		for(int des : graph[sour]){
			if(flag)return;
			if(visit[des])continue;
			countries++;
			dfs(des, depth+1);
		}
	}
}
