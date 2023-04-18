import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		int n = Integer.parseInt(size[0]), m = Integer.parseInt(size[1]);
		int[][] arr = new int[n+1][m+1], sum = new int[n+1][m+1];
		
		for(int i=1 ; i<=n ; i++) {
			String[] values = br.readLine().split(" ");
			for(int j=0 ; j<m ; j++) {
				arr[i][j+1] = Integer.parseInt(values[j]);
			}
		}
		
		for(int i=1 ; i<=n ; i++) {
			for(int j=1 ; j<=m ; j++) {
				sum[i][j] += sum[i-1][j] + arr[i][j] - sum[i-1][j-1] + sum[i][j-1];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String[] str = br.readLine().split(" ");
			int sy = Integer.parseInt(str[0]), sx = Integer.parseInt(str[1]),
					ey = Integer.parseInt(str[2]), ex = Integer.parseInt(str[3]);
			System.out.println(sum[ey][ex] - sum[sy-1][ex] -  sum[ey][sx-1] + sum[sy-1][sx-1]);
			
		}
		
		br.close();
	}
	
	
}
