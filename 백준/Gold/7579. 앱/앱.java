import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[][] apps = new int[n + 1][2];
        int k = 0;
        for (int j = 0; j < 2; j++) {
            tokenizer = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                apps[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (j == 1)
                    k += apps[i][j];
            }
        }

        long[][] dp = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int cost = 0; cost <= k; cost++) {
                if (apps[i][1] > cost) {
                    dp[i][cost] = dp[i - 1][cost];
                    continue;
                }

                dp[i][cost] = Math.max(dp[i - 1][cost], dp[i - 1][cost - apps[i][1]] + apps[i][0]);
            }
        }

        int cost = 0;
        while(cost <= k && dp[n][cost] < m){
            cost++;
        }
        
        System.out.println(cost);

        br.close();
    }
}