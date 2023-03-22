import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, m;
	static int[] parents, ranks;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			parents = new int[n + 1];
			ranks = new int[n + 1];
			
			for(int i=0 ; i<=n ; i++) {
				parents[i] = i;
				ranks[i] = 1;
			}
			
			for(int i=0 ; i<n ; i++) {
				String[] str = br.readLine().split(" ");
				for(int j=0 ; j<n ; j++) {
					if(Integer.parseInt(str[j]) == 1) {
						union(i+1, j+1);
					}
				}
			}
			String[] str = br.readLine().split(" ");
			boolean flag = true;
			for(int i=0 ; i<m-1 ; i++) {
				if(findParent(Integer.parseInt(str[i])) != findParent(Integer.parseInt(str[i+1]))) {
					flag = false;
					break;
				}
			}
			System.out.println(flag ? "YES" : "NO");
			br.close();
		}catch(IOException e) {
			
		}
	}
	
	private static int findParent(int x) {
		if(parents[x] == x)return x;
		return parents[x] = findParent(parents[x]);
	}
	
	private static void union(int x, int y) {
		int px = findParent(x), py = findParent(y);
		if(px == py)return;
		
		if(ranks[px] < ranks[py]) {
			int temp = px;
			px = py;
			py = temp;
		}
		parents[py] = px;
		ranks[py]++;
	}
}
