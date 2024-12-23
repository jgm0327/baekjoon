import java.util.*;

class Solution {
    private int[][] graph;
    private int n, answer;
    
    public int solution(int[] info, int[][] edges) {
        answer = 1;
        n = info.length;
        
        int[] indices = new int[n];
        graph = new int[n][2];
        
        for(int i=0 ; i<n ; i++)
            Arrays.fill(graph[i], -1);
        
        for(int[] edge : edges){
            graph[edge[0]][indices[edge[0]]++] = edge[1];
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, list, info, 0, 0);
        
        return answer;
    }
    
    private void dfs(int parent, ArrayList<Integer> list, int[] info, int sheepCount, int wolfCount){
        if(info[parent] == 0)
            sheepCount++;
        else
            wolfCount++;
        
        if(sheepCount <= wolfCount)
            return;
        
        answer = Math.max(answer, sheepCount);
        ArrayList<Integer> next = new ArrayList<>(list);
        
        if(!next.isEmpty()){
            for(int child : graph[parent]){
                if(child == -1)
                    continue;
                
                next.add(child);
            }
        }
        
        next.remove(Integer.valueOf(parent));
        for(int node : next){
            dfs(node, next, info, sheepCount, wolfCount);
        }
    }
}