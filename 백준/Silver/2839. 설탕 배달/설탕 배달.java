import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 6];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[3] = dp[5] = 1;
        for(int i=6 ; i<=n ; i++){
            if(dp[i - 5] != Integer.MAX_VALUE)
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            else if(dp[i - 3] != Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
        }
        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
        br.close();
    }
}