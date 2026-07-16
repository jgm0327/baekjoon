import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        for(int[] b : board)
            System.out.println(Arrays.toString(b));
        return bfs(board);
    }
    
    int bfs(int[][] board){
        int n = board.length, m = board[0].length;
        
        int[][][] dp = new int[n][m][4];
        for(int i=0 ; i<n ; i++)
            for(int j=0 ; j<m ; j++)
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
        
        Arrays.fill(dp[0][0], 0);
        
        int[] dy = {0, 0, -1, 1}, dx = {1, -1, 0, 0};
        Queue<int[]> que = new ArrayDeque<>();
        // y, x, cost, dir
        que.add(new int[]{0, 0, 0, 4});
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            int y = cur[0], x = cur[1], cost = cur[2], dir = cur[3];
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                
                if(0 > ny || ny >= n || 0 > nx || nx >= m || board[ny][nx] == 1)
                    continue;
                
                int nextCost = cost + 100;
                if(dir != i && dir != 4)
                    nextCost += 500;
                
                if(nextCost > dp[ny][nx][i])
                    continue;
                
                dp[ny][nx][i] = nextCost;
                if(ny == n - 1 && nx == m - 1)
                    continue;
                que.add(new int[]{ny, nx, nextCost, i});
            }
        }
        
        int ret = dp[n - 1][m - 1][0];
        for(int i=0 ; i<4 ; i++){
            ret = Math.min(ret, dp[n - 1][m - 1][i]);
        }
        return ret;
    }
}