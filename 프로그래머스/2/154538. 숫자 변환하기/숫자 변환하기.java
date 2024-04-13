import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = bfs(x, y, n);
        return answer;
    }
    
    private int bfs(int start, int end, int n){
        if(start == end)
            return 0;
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start, 0});
        
        Map<Integer, Boolean> visit = new HashMap<>();
        visit.put(start, true);
        
        final int[][] dx = {{1, n}, {2, 0}, {3, 0}};
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int num = cur[0], dist = cur[1];
            
            for(int i=0 ; i<3 ; i++){
                int nextNum = num * dx[i][0] + dx[i][1];
                
                if(nextNum == end)
                    return dist + 1;
                
                if(visit.containsKey(nextNum) || nextNum > end)
                    continue;
                
                que.add(new int[]{nextNum, dist + 1});
                visit.put(nextNum, true);
            }
        }
        
        return -1;
    }
}