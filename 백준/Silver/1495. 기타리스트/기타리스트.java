import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int s = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] volume = new int[n + 1];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            volume[i] = Integer.parseInt(tokenizer.nextToken());

        Set<Integer>[][] dp = new HashSet[n + 1][];
        for (int i = 0; i <= n; i++) {
            dp[i] = new HashSet[2];
            for (int j = 0; j < 2; j++) {
                dp[i][j] = new HashSet<>();
            }
        }

        dp[0][0].add(s);
        dp[0][1].add(s);

        for (int i = 1; i <= n; i++) {
            for (int num : dp[i - 1][0]) {
                if (num + volume[i] > m) 
                    continue;

                dp[i][0].add(num + volume[i]);
            }

            for (int num : dp[i - 1][1]) {
                if (num + volume[i] > m) 
                    continue;

                dp[i][0].add(num + volume[i]);
            }

            for (int num : dp[i - 1][1]) {
                if (num - volume[i] < 0)
                    continue;
                
                dp[i][1].add(num - volume[i]);
            }

            for (int num : dp[i - 1][0]) {
                if (num - volume[i] < 0)
                    continue;
                
                dp[i][0].add(num - volume[i]);
            }

        }

        int answer = -1;
        for(int j=0 ; j<2 ; j++){
            for(int num : dp[n][j]){
                answer = Math.max(answer, num);
            }
        }
        System.out.println(answer);

        br.close();
    }
}