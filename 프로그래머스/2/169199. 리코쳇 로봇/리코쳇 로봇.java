import java.util.*;

class Solution {
    public int solution(String[] board) {
        int n = board.length, m = board[0].length();
        int startY = -1, startX = -1;
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(board[i].charAt(j) != 'R')
                    continue;
                startY = i;
                startX = j;
            }
        }
        
        return bfs(startY, startX, n, m, board);
    }
    
    private int bfs(int startY, int startX, int n, int m, final String[] board){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startY, startX, 0});
        
        boolean[][] visit = new boolean[n][m];
        visit[startY][startX] = true;
        
        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0], x = cur[1], dist = cur[2];
            
            for(int i=0 ; i<4 ; i++){
                int[] next = getPosition(n, m, y, x, dy[i], dx[i], board);
                int ny = next[0], nx = next[1];
                
                if(visit[ny][nx])
                    continue;
                
                if(board[ny].charAt(nx) == 'G')
                    return dist + 1;
                
                que.add(new int[]{ny, nx, dist + 1});
                visit[ny][nx] = true;
            }
        }
        
        return -1;
    }
    
    private int[] getPosition(int n, int m, int y, int x, int dy, int dx, final String[] board){
        int end = Math.max(n, m);
        
        for(int i=1 ; i<=end ; i++){
            int ny = y + dy * i, nx = x + dx * i;
            
            if(0 > ny || ny >= n || 0 > nx || nx >= m 
               || board[ny].charAt(nx) == 'D')
                return new int[]{ny - dy, nx - dx};
        }
        
        return new int[]{y, x};
    }
}