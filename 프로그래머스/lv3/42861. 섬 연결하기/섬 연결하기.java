import java.util.*;

class Solution {
    private int[] parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        parents = new int[n];
        for(int i=0 ; i<n ; i++)parents[i] = i;
        
        for(int i=0 ; i<costs.length; i++){
            int sour = costs[i][0], des = costs[i][1], cost = costs[i][2];
            pq.add(new int[]{sour, des, cost});
        }
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int sour = cur[0], des = cur[1], cost = cur[2];
            if(findParent(sour) == findParent(des))continue;
            answer += cost;
            union(sour, des);
        }
        return answer;
    }
    
    private int findParent(int x){
        if(x == parents[x])return x;
        return parents[x] = findParent(parents[x]);
    }
    
    private void union(int x, int y){
        int py = findParent(y), px = findParent(x);
        if(py == px)return;
        parents[py] = px;
    }
}