import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][2];
        int[] r = new int[n + 1];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++){
            r[i] = Integer.parseInt(tokenizer.nextToken());
        }

        dp[1][0] = r[0];

        for(int i=1 ; i<=n ; i++){
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + r[i];
            dp[i][1] = dp[i-1][0];
        }
        
        bw.write(String.valueOf(Math.min(dp[n][0], dp[n][1])));

        bw.flush();

        bw.close();
        br.close();
    }
}