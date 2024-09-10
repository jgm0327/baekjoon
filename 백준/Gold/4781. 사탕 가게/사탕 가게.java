import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder answer =  new StringBuilder();

        while(true){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(tokenizer.nextToken());
            int m = (int)(Double.parseDouble(tokenizer.nextToken()) * 100 + 0.5);
            
            if(n == 0 && m == 0.00)
                break;

            int[][] candies = new int[n][2];

            for(int i=0 ; i<n ; i++){
                tokenizer = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(tokenizer.nextToken());
                int p = (int)(Double.parseDouble(tokenizer.nextToken()) * 100 + 0.5);

                candies[i] = new int[] { c, p };
            }

            int[] dp = new int[10001];

            int maxValue = 0;
            for(int i=0 ; i<n ; i++){
                for(int j=1 ; j<=m ; j++){
                    if(j  < candies[i][1]){
                        continue;
                    }

                    dp[j] = Math.max(dp[j], dp[j - candies[i][1]] + candies[i][0]);
                    maxValue = Math.max(maxValue, dp[j]);
                }
            }

            answer.append(maxValue).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}