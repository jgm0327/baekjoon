import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static int answer;
	private static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		dp = new int[12];
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			answer = recur(n, 0);
			bw.write(answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int recur(int num, int depth) {
		if(num <= 0) {
			if(num == 0)return 1;
			return 0;
		}
		if(dp[num] != 0)return dp[num];
		dp[num] += recur(num-3, depth+1);
		dp[num] += recur(num-2, depth+1);
		dp[num] += recur(num-1, depth+1);
		return dp[num]; 
	}
}
