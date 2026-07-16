import java.util.*;

class Solution {
    List<int[]>[] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] costs = new int[n + 1][n + 1];
        graph = new ArrayList[n + 1];
        
        for(int i=1 ; i<=n ; i++){
            graph[i] = new ArrayList<>();
            Arrays.fill(costs[i], Integer.MAX_VALUE);
            costs[i][i] = 0;
        }
        
        for(int[] fare : fares){
            int x = fare[0], y = fare[1];    
            costs[x][y] = costs[y][x] = fare[2];
            graph[x].add(new int[]{y, fare[2]});
            graph[y].add(new int[]{x, fare[2]});
        }
        
        for(int k=1 ; k<=n ; k++){
            for(int i=1 ; i<=n ; i++){
                for(int j=1 ; j<=n ; j++){
                    if(costs[i][k] == Integer.MAX_VALUE 
                       || costs[k][j] == Integer.MAX_VALUE)
                        continue;
                    
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }
    
        return dijkstra(s, a, b, costs);
    }
    
    int dijkstra(int start, int a, int b, int[][] costs){
        Queue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        que.add(new int[]{start, 0});
        
        int[] dists = new int[costs.length];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;
        
        int ret = costs[start][a] + costs[start][b];
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            int sour = cur[0], dist = cur[1];
            if(dist > dists[sour])
                continue;
            
            for(int[] next : graph[sour]){
                int des = next[0];
                
                if(dists[des] <= dist + next[1])
                    continue;
                
                ret = Math.min(ret, dist + next[1] + costs[des][a] + costs[des][b]);
                dists[des] = dist + next[1];
                que.add(new int[]{des, dist + next[1]});
            }
        }
        
        return ret;
    }
}