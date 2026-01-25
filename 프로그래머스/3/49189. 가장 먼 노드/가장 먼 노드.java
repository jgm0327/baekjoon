import java.util.*;

class Solution {
    List<Integer>[] graph;
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] e : edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        return bfs(n);
    }
    
    private int bfs(int n){
        int maxValue = 0;
        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{1, 0});
        
        int answer = 1;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            int sour = cur[0], dist = cur[1];
            for(int des : graph[sour]){
                if(visit[des])
                    continue;
                
                if(dist + 1 == maxValue)
                    answer++;
                else if(dist + 1 > maxValue){
                    maxValue = dist + 1;
                    answer = 1;
                }
                
                visit[des] = true;
                que.add(new int[]{des, dist + 1});
            }
        }
        
        return answer;
    }
}