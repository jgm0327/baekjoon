import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] starirs = new int[n + 3], dp = new int[n + 4];

        for(int i=1 ; i<=n ; i++){
            starirs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = starirs[1];
        dp[2] = starirs[2] + dp[1];
        for(int i=3 ; i<=n ; i++){
            dp[i] = Math.max(dp[i - 2], starirs[i - 1] + dp[i - 3]) + starirs[i];
        }
        System.out.println(dp[n]);
        br.close();
    }
}