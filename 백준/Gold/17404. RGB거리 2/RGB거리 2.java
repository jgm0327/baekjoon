import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] rgb = new int[n][3];
        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            rgb[i][0] = Integer.parseInt(tokenizer.nextToken());
            rgb[i][1] = Integer.parseInt(tokenizer.nextToken());
            rgb[i][2] = Integer.parseInt(tokenizer.nextToken());
        }

        // 시작한 곳, 집 번호, 색
        int[][][] dp = new int[3][n + 1][3];

        int answer = Integer.MAX_VALUE;
        for(int start=0 ; start<3 ; start++){
            dp[start][2][start] = Integer.MAX_VALUE;
            dp[start][2][(start + 1) % 3] = rgb[0][start] + rgb[1][(start + 1) % 3];
            dp[start][2][(start + 2) % 3] = rgb[0][start] + rgb[1][(start + 2) % 3];

            for(int i=2 ; i<n-1 ; i++){
                dp[start][i + 1][0] = Math.min(dp[start][i][1], dp[start][i][2]) + rgb[i][0];
                dp[start][i + 1][1] = Math.min(dp[start][i][0], dp[start][i][2]) + rgb[i][1];
                dp[start][i + 1][2] = Math.min(dp[start][i][1], dp[start][i][0]) + rgb[i][2];
            }

            dp[start][n][(start + 1) % 3] = Math.min(dp[start][n - 1][start], dp[start][n - 1][(start + 2) % 3]) + rgb[n - 1][(start + 1) % 3];
            dp[start][n][(start + 2) % 3] = Math.min(dp[start][n - 1][start], dp[start][n - 1][(start + 1) % 3]) + rgb[n - 1][(start + 2) % 3];

            int minValue = Math.min(dp[start][n][(start + 1) % 3], dp[start][n][(start + 2) % 3]);
            answer = Math.min(minValue, answer);
        }

        System.out.println(answer);
        br.close();
    }
}