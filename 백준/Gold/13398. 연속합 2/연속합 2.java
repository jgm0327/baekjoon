import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException 
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // {{모든 수 합, 제거 O, 제거 X}, ...}
        int[][] dp = new int[n + 1][3];
        int[] numbers = new int[n + 1];

        
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++)
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        
            
        // dp[0][0] = numbers[1];
        // for(int i=1 ; i<=n ; i++){
        //     Arrays.fill(dp[i], numbers[i]);
        // }

        for(int i=1 ; i<=n ; i++){
            dp[i][0] = Math.max(dp[i - 1][0] + numbers[i], numbers[i]);
            dp[i][1] = dp[i - 1][0];
            dp[i][2] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]) + numbers[i];
        }

        int answer = Integer.MIN_VALUE;
        for(int i=1 ; i<=n ; i++){
            int maxValue = Math.max(dp[i][0], dp[i][2]);
            
            answer = Math.max(answer, maxValue);
        }

        System.out.println(answer);
        br.close();
	}
}