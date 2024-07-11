import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    private int bfs(int x, int y, int n){
        if(x == y)return 0;
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        Map<Integer, Boolean> visit = new HashMap<>();
        
        visit.put(x, true);
        que.add(new int[]{x, 0});
        
        final int[][] dx = {{2,0},{3,0},{1,n}};
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            int curX = cur[0], dist = cur[1];
            
            for(int i=0 ; i<3 ; i++){
                int nx = curX * dx[i][0] + dx[i][1];
                
                if(nx == y){
                    return dist + 1;
                }
                
                if(nx > y || visit.containsKey(nx)){
                    continue;
                }
                
                visit.put(nx, true);
                que.add(new int[]{nx, dist + 1});
            }
        }
        
        return -1;
    }
}