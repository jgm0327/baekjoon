import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());

        int[][] board = new int[M + 1][N + 1];
        int[][] dp = new int[M + 1][N + 1];

        for(int i=1 ; i<=M ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            for(int j=1 ; j<=N ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
                if(board[i][j] == 0)
                    dp[i][j] = 1;
            }
        }

        int answer = 0;

        for(int i=1 ; i<=M ; i++){
            
            for(int j=1 ; j<=N ; j++){
                if(board[i][j] != 0)
                    continue;

                if(board[i - 1][j - 1] == 0 && board[i - 1][j] == 0 && board[i][j - 1] == 0){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }

                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}