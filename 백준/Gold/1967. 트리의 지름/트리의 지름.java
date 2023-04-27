import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

	public class Main {
		private static int n, answer = 0;
		private static List<int[]>[] tree;
		private static boolean[] visit;
		
		public static void main(String[] args) throws IOException{
			init();
			solution();
		}
		
		private static void init() throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			
			tree = new ArrayList[n+1];
			for(int i=0 ; i<=n ; i++)tree[i] = new ArrayList<>();
			
			visit = new boolean[n+1];
			
			for(int i=0 ; i<n-1 ; i++) {
				String[] values = br.readLine().split(" ");
				int parent = Integer.parseInt(values[0]),
						child = Integer.parseInt(values[1]),
						length = Integer.parseInt(values[2]);
				tree[parent].add(new int[] {child, length});
				tree[child].add(new int[] {parent, length});
			}
			
			br.close();
		}
		
		private static void solution() {
			for(int i = 1 ; i <= n ; i++) {
				visit = new boolean[n+1];
				visit[i] = true;
				dfs(i, 0);
			}
			System.out.println(answer);
		}
		
		private static void dfs(int parent, int total) {
			visit[parent] = true;
			for(int[] data : tree[parent]) {
				int child = data[0], length = data[1];
				if(!visit[child]) {
					dfs(child, total + length);
				}
			}
			answer = Math.max(answer, total);
		}
}
