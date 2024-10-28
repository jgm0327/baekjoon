import java.io.*;
import java.util.*;;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] coins = new int[n];
        int[] dp = new int[k + 1];

        Arrays.fill(dp, 1_000_001);

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] <= k)
                dp[coins[i]] = 1;
        }

        for (int coin : coins) {
            for (int i = 1; i <= k; i++) {
                if (coin > i || dp[i - coin] == 0) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if(dp[k] == 1000_001)
            dp[k] = -1;

        bw.write(String.valueOf(dp[k]));
        bw.close();
        br.close();
    }
}
