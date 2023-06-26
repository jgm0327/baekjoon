import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    private int bfs(int num, int target, int n){
        if(num == target)return 0;
        
        Queue<int[]> que = new LinkedList<>();
        Map<Integer, Boolean> visit = new HashMap<>();
        que.add(new int[]{num, 0});
        visit.put(num, true);
        int[] d = new int[]{2,3,n};
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int sour = cur[0], cnt = cur[1];
            for(int i=0 ; i<3 ; i++){
                int next = sour * d[i];
                if(i == 2) next = sour + d[i];
                if(target == next)return cnt + 1;
                if(next <= 0 || next > target || visit.containsKey(next))continue;
                que.add(new int[]{next, cnt + 1});
                visit.put(next, true);
            }
        }
        return -1;
    }
}