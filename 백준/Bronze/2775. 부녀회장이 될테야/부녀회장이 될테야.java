import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[15][15];
		
		for(int i=1 ; i<=14 ;i++) {
			dp[0][i] = i;
			dp[i][1] = 1;
		}
		
		for(int i=1 ; i<=14 ; i++) {
			for(int j=2 ; j<=14 ; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		int n, k;
		while(T-- > 0) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			bw.write(dp[k][n] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
