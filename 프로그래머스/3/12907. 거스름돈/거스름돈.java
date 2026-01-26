import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int len = money.length;
        
        int[][] dp = new int[len + 1][n + 1];
        dp[0][0] = 1;
        
        for(int i=1 ; i<=len ; i++){
            int value = money[i - 1];
            
            for(int m=0 ; m<=n ; m++){
                if(value > m){
                    dp[i][m] = dp[i - 1][m];
                    continue;
                }
                
                dp[i][m] = dp[i - 1][m] + dp[i][m - value];
            }
        }
        
        return dp[len][n];
    }
}