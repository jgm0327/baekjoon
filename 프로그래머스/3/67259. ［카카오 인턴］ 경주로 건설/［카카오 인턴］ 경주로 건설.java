import java.util.*;

class Solution {
    class Car{
        int y, x, dir, cost;
        
        public Car(int y, int x, int dir, int cost){
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    final int[] dy = {1, 0, -1, 0}, dx = {0, 1, 0, -1};
    public int solution(int[][] board) {
        int answer = 0;
        return bfs(board);
    }
    
    int bfs(int[][] board){
        int n = board.length;
        
        Queue<Car> que = new ArrayDeque<>();
        que.add(new Car(0, 0, 0, 0));
        que.add(new Car(0, 0, 1, 0));
        
        int[][][] dp = new int[n][n][4];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);       
            }
        }
        
        for(int i=0 ; i<4 ; i++)
            dp[0][0][i] = 0;
        
        while(!que.isEmpty()){
            Car car = que.poll();
            
            for(int i=0 ; i<4 ; i++){
                int ny = car.y + dy[i], nx = car.x + dx[i];
                int cost = 100;
                
                if(i != car.dir) 
                    cost = 600;
                
                if(0 > ny || ny >= n || 0 > nx || nx >= n
                   || board[ny][nx] == 1 || dp[ny][nx][i] <= car.cost + cost)
                    continue;
                
                dp[ny][nx][i] = car.cost + cost;
                if(ny == n - 1 && nx == n - 1)
                    continue;
                
                que.add(new Car(ny, nx, i, dp[ny][nx][i]));
            }
        }
        
        int ret = Integer.MAX_VALUE;
        for(int i=0 ; i<4 ; i++){
            ret = Math.min(dp[n - 1][n - 1][i], ret);
        }
        
        return ret;
    }
}