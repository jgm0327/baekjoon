import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n + 2];

            int[][] dp = new int[2][n + 2];

            for (int i = 0; i < 2; i++) {
                StringTokenizer tokenizer = new StringTokenizer(br.readLine());

                for (int j = 1; j <= n; j++)
                    stickers[i][j] = Integer.parseInt(tokenizer.nextToken());
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(Math.max(dp[0][i - 2], dp[1][i - 1]) + stickers[0][i], dp[0][i - 1]);
                dp[1][i] = Math.max(Math.max(dp[1][i - 2], dp[0][i - 1]) + stickers[1][i], dp[1][i - 1]);
            }

            answer.append(Math.max(dp[1][n], dp[0][n])).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}