import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[] arr;
	private static StringBuilder answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());

		tokenizer = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0 ; i<n ; i++){
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}

		Arrays.sort(arr);

		answer = new StringBuilder();
		dfs(0, new int[m], new boolean[n]);

		System.out.print(answer);
		br.close();
	}

	private static void dfs(int depth, int[] path, boolean[] visit){
		if(depth == m){
			for(int i=0 ; i<m ; i++){
				answer.append(path[i]).append(" ");
			}
			answer.append("\n");
			return;
		}

		for(int i=0 ; i<n ; i++){
			if(visit[i] || path[depth] == arr[i])
				continue;

			visit[i] = true;
			path[depth] = arr[i];
			dfs(depth + 1, path, visit);
			visit[i] = false;
		}
		path[depth] = 0;
	}
}
