import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0, 1});
        int n = maps.length, m = maps[0].length;
        
        boolean[][] visit = new boolean[n][m];
        visit[0][0] = true;
        
        int[] dy = {0,0,1,-1}, dx = {-1,1,0,0};
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            int y = cur[0], x = cur[1];
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                
                if(0 > ny || ny >= n || 0 > nx || nx >= m || visit[ny][nx] || maps[ny][nx] == 0)
                    continue;
                
                if(ny == n - 1 && nx == m - 1)
                    return cur[2] + 1;
                
                que.add(new int[]{ny, nx, cur[2] + 1});
                visit[ny][nx] = true;
            }
            
        }
        return -1;
    }
}