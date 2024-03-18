import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n + 1];
            
            for(int i=0 ; i<2 ; i++){
                StringTokenizer stk = new StringTokenizer(br.readLine());
                for(int j=1 ; j<=n ; j++){
                    stickers[i][j] = Integer.parseInt(stk.nextToken());
                }
            }

            int[][] dp = new int[2][n + 1];

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for(int i=2 ; i<=n ; i++){
                dp[0][i] = Math.max(dp[0][i - 2] + stickers[1][i - 1], Math.max(dp[1][i - 1], dp[1][i - 2])) + stickers[0][i];
                dp[1][i] = Math.max(Math.max(dp[0][i - 1], dp[0][i - 2]), dp[1][i - 2] + stickers[0][i - 1]) + stickers[1][i];
            }

            answer.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }

        System.out.print(answer);
    }
}