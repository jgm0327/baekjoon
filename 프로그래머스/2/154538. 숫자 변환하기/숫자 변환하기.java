import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(y == x)
            return 0;
        
        Queue<int[]> que = new ArrayDeque<>();
        int[][] dx = {{2, 0}, {3, 0}, {1, n}};
        
        que.add(new int[]{x, 0});
        boolean[] visit = new boolean[1000_001];
        visit[x] = true;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            int cx = cur[0], dist = cur[1];
            for(int i=0 ; i<3 ; i++){
                int nx = cx * dx[i][0] + dx[i][1];
                
                if(nx > y || visit[nx])
                    continue;
                
                if(nx == y)
                    return dist + 1;
                
                visit[nx] = true;
                que.add(new int[]{nx, dist + 1});
            }
        }
        
        return -1;
    }
}