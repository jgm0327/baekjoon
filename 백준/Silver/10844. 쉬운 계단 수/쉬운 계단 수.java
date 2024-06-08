import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][10];

        for(int i=1 ; i<10 ; i++){
            dp[1][i] = 1;
        }

        int mod = 1000000000;
        for(int i=2 ; i<=n ; i++){
            dp[i][0] = dp[i - 1][1];

            for(int j=1 ; j<9 ; j++){
                dp[i][j] = ((dp[i - 1][j - 1] % mod) + (dp[i - 1][j + 1] % mod)) % 1000000000;
            }

            dp[i][9] = dp[i - 1][8];
        }

        int total = 0;
        for(int i=0 ; i<10 ; i++){
            total = ((total % mod) + (dp[n][i] % mod)) % mod;
        }
        System.out.println(total);
    }
}