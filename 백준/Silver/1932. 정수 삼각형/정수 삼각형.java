import java.io.*;
import java.util.*;;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        for(int i=1 ; i<=n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for(int j=1 ; j<=i ; j++){
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = arr[1][1];

        for(int i=2 ; i<=n ; i++){
            for(int j=1 ; j<=i ; j++){
                if(j == 1)dp[i][j] = dp[i - 1][j];
                else if(j == i)dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);

                dp[i][j] += arr[i][j];
            }
        }

        int answer = 0;
        for(int j=1 ; j<=n ; j++){
            answer = Math.max(answer, dp[n][j]);
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
