import java.util.*;

class Solution {
    private int[] costs;
    private List<Integer>[] graph;
    private int max;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[1] = 0;
        
        graph = new ArrayList[n + 1];
        for(int i=1 ; i<=n ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0 ; i<edge.length ; i++){
            int sour  = edge[i][0], des = edge[i][1];
            graph[sour].add(des);
            graph[des].add(sour);
        }
        
        dijkstra();
        
        for(int i=1 ; i<=n ; i++){
            if(max == costs[i])answer++;
        }
        
        return answer;
    }
    
    private void dijkstra(){
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {1, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int sour = cur[0], cost = cur[1];
            if(costs[sour] < cost)continue;
            for(int des : graph[sour]){
                int nextCost = cost + 1;
                if(nextCost < costs[des]){
                    pq.add(new int[]{des, nextCost});
                    costs[des] = nextCost;
                    max = Math.max(max, nextCost);
                }
            }
        }
    }
}