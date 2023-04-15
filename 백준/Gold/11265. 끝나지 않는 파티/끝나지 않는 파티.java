import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] size = br.readLine().split(" ");
		int n = Integer.parseInt(size[0]);
		int m = Integer.parseInt(size[1]);
		int[][] graph = new int[n+1][n+1];
		
		for(int i=1 ; i<=n ; i++) {
			String[] values = br.readLine().split(" ");
			for(int j=1 ; j<=n ; j++) {
				graph[i][j] = Integer.parseInt(values[j-1]);
			}
		}
		
		for(int k=1 ; k<=n ; k++) {
			for(int i=1 ; i<=n ; i++) {
				for(int j=1 ; j<=n ; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		while(m-- > 0) {
			String[] str = br.readLine().split(" ");
			int sour = Integer.parseInt(str[0]), des = Integer.parseInt(str[1]), interval = Integer.parseInt(str[2]);
			bw.write(graph[sour][des] <= interval ? "Enjoy other party\n" : "Stay here\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
