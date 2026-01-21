import java.util.*;

class Solution {
    List<Integer>[] graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n + 1];
        for(int i=0 ; i<n+1 ; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] road : roads){
            int a = road[0], b = road[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int i=0 ; i<sources.length ; i++){
            answer[i] = dijkstra(sources[i], destination, n);
        }
        
        return answer;
    }
    
    int dijkstra(int start, int end, int n){
        if(start == end)
            return 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});
        
        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int sour = cur[0], dist = cur[1];
            
            for(int des : graph[sour]){
                if(des == end)
                    return dist + 1;
                
                if(costs[des] <= dist + 1)
                    continue;
                
                costs[des] = dist + 1;
                pq.add(new int[]{des, costs[des]});
            }
        }
        
        return -1;
    }
}