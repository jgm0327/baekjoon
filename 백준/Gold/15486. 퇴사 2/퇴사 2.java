import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] appointment = new int[n + 2][2];

        for(int i=1 ; i<=n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            appointment[i][0] = Integer.parseInt(tokenizer.nextToken());
            appointment[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] dp = new int[n + 2];

        int max = 0;
        for(int i=1 ; i<=n+1 ; i++){
            max = Math.max(max, dp[i]);
            int endTime = appointment[i][0] + i;

            if(endTime > n + 1)
                continue;

            dp[endTime] = Math.max(appointment[i][1] + max, dp[endTime]);   
        }

        bw.write(String.valueOf(dp[n + 1]));
        
        bw.close();
        br.close();
    }
}