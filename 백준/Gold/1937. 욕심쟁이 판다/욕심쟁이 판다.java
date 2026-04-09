import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
    static int[][] board;
    static int[][] dp;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int answer = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                answer = Math.max(answer, dfs(i, j));
            }
        }
        System.out.println(answer + 1);

        br.close();
    }

    static int dfs(int y, int x){
        if(dp[y][x] != -1)
            return dp[y][x];

        dp[y][x] = 0;
        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i], nx = x + dx[i];

            if(0 > ny || ny >= n || 0 > nx || nx >= n || board[y][x] >= board[ny][nx])
                continue;

            dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
        }

        return dp[y][x];
    }
}