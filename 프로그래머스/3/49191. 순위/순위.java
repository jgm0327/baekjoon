import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] win = new int[n + 1][n + 1];
        int[][] lose = new int[n + 1][n + 1];
        
        for(int i=0 ; i<=n ; i++){
            Arrays.fill(win[i], Integer.MAX_VALUE);
            Arrays.fill(lose[i], Integer.MAX_VALUE);
        }
        
        for(int[] result : results){
            int sour = result[0];
            int des = result[1];
            
            win[sour][des] = 1;
            lose[des][sour] = 1;
        }
        
        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    if(win[i][k] != Integer.MAX_VALUE 
                       && win[k][j] != Integer.MAX_VALUE){
                        
                        win[i][j] = 1;
                    }
                    
                    if(lose[i][k] != Integer.MAX_VALUE
                      && lose[k][j] != Integer.MAX_VALUE){
                        lose[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i=1 ; i<=n ; i++){
            int total = 0;
            for(int j=1 ; j<=n ; j++){
                if(win[i][j] == Integer.MAX_VALUE 
                   && lose[i][j] == Integer.MAX_VALUE)continue;
                total++;
            }
            
            if(total != n - 1)continue;
            answer++;
        }
        
        return answer;
    }
}