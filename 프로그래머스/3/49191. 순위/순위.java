import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        List<Integer>[] graph = new ArrayList[n + 1];
        List<Integer>[] reverse = new ArrayList[n + 1];
        
        for(int i=1; i<=n ; i++){
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        
        for(int[] result : results){
            int a = result[0], b = result[1];
            
            graph[a].add(b);
            reverse[b].add(a);
        }
        
        int answer = 0;
        for(int i=1 ; i<=n ; i++){
            if(bfs(i, graph) + bfs(i, reverse) == n - 1)
                answer++;
        }
        
        return answer;
    }
    
    int bfs(int start, List<Integer>[] graph){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        
        boolean[] visit = new boolean[graph.length];
        visit[start] = true;
        
        int ret = 0;
        while(!que.isEmpty()){
            int cur = que.poll();
            
            for(int next : graph[cur]){
                if(visit[next])
                    continue;
                
                ret++;
                visit[next] = true;
                que.add(next);
            }
        }
        
        return ret;
    }
    
    
}