class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length, m = board[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int[][] tempBoard = new int[n + 1][m + 1];
        int answer = 0;
        
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m ; j++){
                tempBoard[i][j] = board[i - 1][j - 1];
                dp[i][j] = tempBoard[i][j];
            }
        }
        
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m ; j++){
                if(tempBoard[i - 1][j - 1] == 0 || tempBoard[i - 1][j] == 0
                  || tempBoard[i][j] == 0 || tempBoard[i][j - 1] == 0)
                    continue;
                
                if(dp[i - 1][j] < 1)continue;
                
                dp[i][j] = Math.min(dp[i][j - 1], 
                                    Math.min(dp[i-1][j-1], dp[i - 1][j])) + 1;
            }
        }
        
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m ; j++){
                answer = Math.max(answer, dp[i][j] * dp[i][j]);
            }
        }

        return answer;
    }
}