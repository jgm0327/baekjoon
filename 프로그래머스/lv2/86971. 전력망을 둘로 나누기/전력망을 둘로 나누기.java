import java.util.*;

class Solution {
    private int[][] edges;
    private boolean[] visit;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        edges = new int[n+1][n+1];
        
        for(int[] wire : wires){
            int sour = wire[0], des = wire[1];
            edges[sour][des] = edges[des][sour] = 1;
        }
        
        for(int[] wire : wires){
            int sour = wire[0], des = wire[1];
            edges[sour][des] = edges[des][sour] = 0;
            visit = new boolean[n + 1];
            answer = Math.min(answer, search(n));
            edges[sour][des] = edges[des][sour] = 1;
        }
        return answer;
    }
    
    private int search(int n){
        int idx = 0;
        int[] arr = new int[2];
        
        for(int i=1 ; i<=n ; i++){
            if(visit[i])continue;
            arr[idx++] = bfs(i, n);
        }
        return Math.abs(arr[0] - arr[1]);
    }
    
    private int bfs(int start, int n){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        int ret = 0;
        visit[start] = true;
        
        while(!que.isEmpty()){
            int sour = que.poll();
            ret++;
            for(int i=1 ; i<=n ; i++){
                if(edges[i][sour] == 0 || visit[i])continue;
                que.add(i);
                visit[i] = true;
            }
        }
        return ret;
    }
}