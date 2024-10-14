import java.util.*;

class Solution {
    public int solution(String numbers) {
        // 그리디, dp
        int answer = 0;
        final int[][] weights = {{1, 7, 6, 7, 5, 4, 5, 3, 2, 3},
                           {7, 1, 2, 4, 2, 3, 5, 4, 5, 6},
                           {6, 2, 1, 2, 3, 2, 3, 5, 4, 5},
                           {7, 4, 2, 1, 5, 3, 2, 6, 5, 4},
                           {5, 2, 3, 5, 1, 2, 4, 2, 3, 5},
                           {4, 3, 2, 3, 2, 1, 2, 3, 2, 3},
                           {5, 5, 3, 2, 4, 2, 1, 5, 3, 2},
                           {3, 4, 5, 6, 2, 3, 5, 1, 2, 4},
                           {2, 5, 4, 5, 3, 2, 3, 2, 1, 2},
                           {3, 6, 5, 4, 5, 3, 2, 4, 2, 1}};
        
        int n = numbers.length();
        
        // 숫자 길이, 왼 or 오, {값, 오, 왼}
        int[][][] dp = new int[n + 1][10][10];
        for(int i=0 ; i<=n ; i++){
            for(int j=0 ; j<10 ; j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        int first = numbers.charAt(0) - '0';
        dp[0][4][6] = 0;
        
        for(int i=1 ; i<=n ; i++){
            int nextNumber = numbers.charAt(i - 1) - '0';
            
            for(int left=0 ; left<10 ; left++){
                for(int right = 0 ; right<10 ; right++){
                    if(left == right || dp[i - 1][left][right] == Integer.MAX_VALUE)
                        continue;
                    
                    int leftWeight = weights[left][nextNumber];
                    int rightWeight = weights[right][nextNumber];
                    
                    
                    dp[i][nextNumber][right] = Math.min(dp[i][nextNumber][right], 
                                                        leftWeight + dp[i - 1][left][right]);
                    
                    dp[i][left][nextNumber] = Math.min(dp[i][left][nextNumber], 
                                                       rightWeight + dp[i - 1][left][right]);
                }
            }
        }
        
        answer = Integer.MAX_VALUE;
        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j<10 ; j++){
                answer = Math.min(answer, dp[n][i][j]);
            }
        }
        
        return answer;
    }
}