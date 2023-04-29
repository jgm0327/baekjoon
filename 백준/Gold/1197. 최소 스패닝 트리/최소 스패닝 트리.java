import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

	public class Main {
		private static class Node implements Comparable<Node>{
			int sour, des, weight;
			
			public Node(int sour, int des, int weight) {
				this.sour = sour;
				this.des = des;
				this.weight = weight;
			}

			@Override
			public int compareTo(Node obj) {
				return this.weight - obj.weight;
			}
		}
		private static int n, m;
		private static Queue<Node> que;
		private static List<Integer> path;
		private static int[] parents;
		
		public static void main(String[] args) throws IOException{
			init();
			solution();
		}
		
		private static void init() throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] size = br.readLine().split(" ");
			n = Integer.parseInt(size[0]);
			m = Integer.parseInt(size[1]);
			parents = new int[n+1];
			
			for(int i=0 ; i<=n ; i++)parents[i] = i;
			
			que = new PriorityQueue<>();
			path = new ArrayList<>();
			
			while(m-- > 0) {
				String[] values = br.readLine().split(" ");
				int sour = Integer.parseInt(values[0]);
				int des = Integer.parseInt(values[1]);
				int weight = Integer.parseInt(values[2]);
				que.add(new Node(sour, des, weight));
			}
			
			br.close();
		}
		
		private static int findParents(int x) {
			if(parents[x] == x)return x;
			return parents[x] = findParents(parents[x]);
		}
		
		private static void union(int x, int y) {
			int px = findParents(x), py = findParents(y);
			if(px == py)return;
			parents[py] = px;
		}
		
		private static void solution() {
			while(!que.isEmpty() && path.size() <= n) {
				Node node = que.poll();
				int sour = node.sour, des = node.des;
				if(findParents(sour) == findParents(des))continue;
				union(sour, des);
				path.add(node.weight);
			}
			
			int ret = 0;
			for(int value : path) {
				ret += value;
			}
			System.out.println(ret);
		}
}
