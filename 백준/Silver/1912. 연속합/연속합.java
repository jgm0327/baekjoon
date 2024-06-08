import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for(int i=1 ; i<=n ; i++){
            numbers[i] = Integer.parseInt(stk.nextToken());
        }

        int[] dp = new int[n + 1];
        for(int i=1 ; i<=n ; i++){
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
        }

        int answer = -1001;
        for(int i=1 ; i<=n ; i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}