import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n, m;
	static int[] parents, ranks;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]); m = Integer.parseInt(str[1]);
			parents = new int[n + 1];
			ranks = new int[n + 1];
			
			for(int i=0 ; i<=n ; i++) {
				parents[i] = i;
				ranks[i] = 1;
			}
			while(m-- > 0) {
				str = br.readLine().split(" ");
				int opt = Integer.parseInt(str[0]);
				int parent = Integer.parseInt(str[1]);
				int child = Integer.parseInt(str[2]);
				if(opt == 0)union(parent, child);
				else bw.write(findParent(parent) == findParent(child) ? "YES\n" : "NO\n");
			}
			br.close();
			bw.close();
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
