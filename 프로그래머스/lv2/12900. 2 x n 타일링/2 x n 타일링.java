class Solution {
    /*
    n = 1 | 1
    n = 2 | 2
    n = 3 | 3
    n = 4 | 5
    
    */
    public int solution(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3 ; i<= n ;i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
        }
        return dp[n];
    }
}