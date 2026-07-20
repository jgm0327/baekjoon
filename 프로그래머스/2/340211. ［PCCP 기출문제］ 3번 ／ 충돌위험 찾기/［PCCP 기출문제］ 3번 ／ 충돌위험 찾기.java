import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int n = 0, m = 0;
        for(int[] point : points){
            n = Math.max(n, point[0]);
            m = Math.max(m, point[1]);
        }
        
        Map<Integer, Integer>[][] dp = new HashMap[n + 1][m + 1];
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m ; j++)
                dp[i][j] = new HashMap<>();
        }
        
        for(int[] route : routes){
            int time = 0;
            
            int a = route[0] - 1;
            int y = points[a][0], x = points[a][1];
            
            dp[y][x].put(time, dp[y][x].getOrDefault(time, 0) + 1);
            for(int i=1 ; i<route.length ; i++){
                int b = route[i] - 1;
                int endY = points[b][0], endX = points[b][1];
                while(endY != y || endX != x){
                    if(endY > y)
                        y++;
                    else if(endY < y)
                        y--;
                    else if(endX < x)
                        x--;
                    else
                        x++;

                    time++;
                    dp[y][x].put(time, dp[y][x].getOrDefault(time, 0) + 1);
                }
            }
        }
        
        int answer = 0;
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= m ; j++) {
                for(int count : dp[i][j].values()) {
                    if(count > 1) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}