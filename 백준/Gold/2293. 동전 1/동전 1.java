import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n, m;
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        int[] coins = new int[n + 1];
        int[] dp = new int[m + 1];

        for(int i=1 ; i<=n ; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for(int i=1 ; i<=n ; i++){
            for(int coin = coins[i] ; coin <= m ; coin++){
                dp[coin] += dp[coin - coins[i]];
            }
        }

        System.out.println(dp[m]);
    }
}