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

        int[][] dp = new int[n + 1][3];

        for(int i=0 ; i<n ; i++){
            dp[i + 1][0] = Math.min(dp[i][1], dp[i][2]) + rgb[i][0];
            dp[i + 1][1] = Math.min(dp[i][0], dp[i][2]) + rgb[i][1];
            dp[i + 1][2] = Math.min(dp[i][1], dp[i][0]) + rgb[i][2];
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0 ; i<3 ; i++){
            answer = Math.min(dp[n][i], answer);
        }

        System.out.println(answer);
        br.close();
    }
}