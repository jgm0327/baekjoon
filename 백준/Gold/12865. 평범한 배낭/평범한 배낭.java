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

        int[][] backpack = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());

            backpack[i] = new int[] { w, v };
        }

        int[][] dp = new int[n + 1][m + 1];

        for(int i=1 ; i<=n ; i++){
            for(int weight=0 ; weight<=m ; weight++){
                if(backpack[i][0] > weight){
                    dp[i][weight] = dp[i - 1][weight];
                    continue;
                }

                dp[i][weight] = Math.max(dp[i - 1][weight], dp[i - 1][weight - backpack[i][0]] + backpack[i][1]);
            }
        }

        System.out.println(dp[n][m]);

        br.close();
    }
}