import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
    static int[][] board, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        board = new int[n][m];
        dp = new int[n][m];
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            for(int j=0 ; j<m ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));

        br.close();
    }

    static int dfs(int y, int x){
        if(y == n - 1 && x == m - 1){
            return 1;
        }

        if(dp[y][x] != -1)
            return dp[y][x];

        dp[y][x] = 0;
        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i], nx = x + dx[i];
            if(0 > ny || ny >= n || 0 > nx || nx >= m || board[y][x] <= board[ny][nx])
                continue;

            dp[y][x] += dfs(ny, nx);
        }


        return dp[y][x];
    }
}