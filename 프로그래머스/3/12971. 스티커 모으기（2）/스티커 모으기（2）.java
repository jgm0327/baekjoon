class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        
        // {현재 위치 스티커 뗌, 현재 위치 스티커 안 뗌}
        int[][] dp = new int[n][2];
        
        dp[0][0] = sticker[0];
        if(n > 1) {
            dp[1][0] = sticker[1];
            dp[1][1] = sticker[0];
        }
        
        for(int i=2 ; i<n-1 ; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + sticker[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        
        int[][] dp2 = new int[n][2];
        if(n > 1) {
            dp2[1][0] = sticker[1];
        }
        
        for(int i=2 ; i<n ; i++){
            dp2[i][0] = Math.max(dp2[i - 1][0], dp2[i - 1][1] + sticker[i]);
            dp2[i][1] = Math.max(dp2[i - 1][0], dp2[i - 1][1]);
        }
        
        int max1 = sticker[0];
        if(n - 2 >= 0)
            max1 = Math.max(dp[n - 2][0], dp[n - 2][1]);
        int max2 = Math.max(dp2[n - 1][0], dp2[n - 1][1]);

        return Math.max(max1, max2);
    }
}