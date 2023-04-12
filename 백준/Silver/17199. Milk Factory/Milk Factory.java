import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static int n, cnt;
	private static List<Integer>[] belt;
	private static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n+1];
		
		belt = new ArrayList[n+1];
		for(int i=0 ; i<=n ; i++) {
			belt[i] = new ArrayList<>();
		}
		
		for(int i=0 ; i<n-1 ; i++) {
			String[] input = br.readLine().split(" ");
			int sour = Integer.parseInt(input[0]), des = Integer.parseInt(input[1]);
			belt[des].add(sour);
		}
		solution();
		br.close();
	}
	
	private static void solution() {
		for(int i=1 ; i<=n ; i++) {
			visit = new boolean[n + 1];
			cnt = 0;
			dfs(i);
			if(cnt == n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
	
	private static void dfs(int sour) {
		if(visit[sour])return;
		visit[sour] = true;
		cnt++;
		for(int des : belt[sour]) {
			if(!visit[des]) {
				dfs(des);
			}
		}
	}
}
