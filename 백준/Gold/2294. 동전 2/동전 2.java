import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{    

    /*
     * 1 => 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
     * 5 => 1 2 3 4 1 2 3 4 5 2
     */

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n, m;
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        int[] coins = new int[n + 1];

        for(int i=1 ; i<=n ; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int i=1 ; i<=n ; i++){
            for(int coin = coins[i] ; coin <= m ;coin++){
                dp[coin] = Math.min(dp[coin - coins[i]] + 1, dp[coin]);
            }
        }

        System.out.println(dp[m] == 10001 ? -1 : dp[m]);
    }
}