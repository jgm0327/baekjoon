import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int[] dy = { 0, 1 }, dx = { 1, 0 };
    static int[][] board;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));

        br.close();
    }

    static long dfs(int y, int x) {
        if(y == n - 1 && x == n - 1)
            return 1;

        if(dp[y][x] != -1)
            return dp[y][x];

        dp[y][x] = 0;
        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i] * board[y][x], nx = x + dx[i] * board[y][x];

            if (0 > ny || ny >= n || 0 > nx || nx >= n)
                continue;

            dp[y][x] += dfs(ny, nx);
        }

        return dp[y][x];
    }
}