import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int[] numbers = new int[n + 1];
        for(int i=1 ; i<=n ; i++){
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        long[][] dp = new long[n + 1][2];
        dp[1][0] = 0;
        dp[1][1] = numbers[1];

        for(int i=2 ; i<=n ; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i-1][1]) + numbers[i];
        }

        System.out.println(Math.min(dp[n][0], dp[n][1]));
    }
}