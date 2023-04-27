import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

	public class Main {
		private static int n, root, k, answer;
		private static List<Integer>[] tree;
		
		public static void main(String[] args) throws IOException{
			init();
			dfs(root);
			System.out.println(answer);
		}
		
		private static void init() throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			tree = new ArrayList[n];
			answer = 0;
			for(int i=0 ; i<n ; i++)tree[i] = new ArrayList<>();
			
			String[] values = br.readLine().split(" ");
			for(int i=0 ; i<n ; i++) {
				int parent = Integer.parseInt(values[i]);
				if(parent == -1) {
					root = i;
					continue;
				}
				tree[parent].add(i);
			}
			k = Integer.parseInt(br.readLine());
			br.close();
		}
		
		private static void dfs(int parent) {
			if(parent == k)return;
			if(tree[parent].isEmpty()) {
				answer++;
				return;
			}
			boolean flag = true;
			for(int child : tree[parent]) {
				if(child == k)continue;
				flag = false;
				dfs(child);
			}
			if(flag)answer++;
		}
}
