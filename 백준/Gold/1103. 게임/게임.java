import java.io.*;
import java.util.*;

class Main {

    private static int n, m;
    private static int[][] dp;
    private static char[][] board;
    private static int[] dy = {0,0,-1,1}, dx = {1,-1,0,0};
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        board = new char[n][m];
        for(int i=0 ; i<n ; i++){
            String input = br.readLine();

            for(int j=0 ; j<m ; j++){
                board[i][j] = input.charAt(j);
            }
        }

        dp = new int[n][m];
        visit = new boolean[n][m];
        dfs(0, 0);

        bw.write(String.valueOf(dp[0][0] + 1));

        bw.close();
        br.close();
    }

    private static int dfs(int y, int x){

        
        if(visit[y][x]){
            System.out.println(-1);
            System.exit(0);
        }
        if(dp[y][x] != 0)return dp[y][x];

        int num = board[y][x] - '0';
        visit[y][x] = true;
        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i] * num, nx = x + dx[i] * num;

            if(0 > ny || ny >= n || 0 > nx || nx >= m 
            || board[ny][nx] == 'H')
                continue;

            dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
        }
        visit[y][x] = false;

        return dp[y][x];

    }
}