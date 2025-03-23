import java.io.*;
import java.util.*;

class Main {
    static int[][] board;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        board = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[][] dp = new int[n + 1][m + 1];

        int[] dy = { 0, -1, -1 }, dx = { -1, 0, -1 };
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                for(int i = 0 ; i < 3 ; i++){
                    int py = y + dy[i], px = x + dx[i];

                    dp[y][x] = Math.max(dp[y][x], dp[py][px] + board[y][x]);
                }
            }
        }

        System.out.println(dp[n][m]);
        br.close();
    }
}