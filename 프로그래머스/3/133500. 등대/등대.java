import java.util.*;

class Solution {
    List<Integer>[] graph;
    int answer = 0;
    
    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList[n + 1];
        
        for(int i=0 ; i<=n ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] house : lighthouse){
            int sour = house[0], des = house[1];
            graph[sour].add(des);
            graph[des].add(sour);
        }
        
        dfs(1, 1);
        return answer;
    }
    
    private boolean dfs(int sour, int parent){
        boolean isLightHouse = false;
        
        for(int des : graph[sour]){
            if(des != parent){
                if(!dfs(des, sour)){
                    isLightHouse = true;
                }
            }
        }
        
        if(isLightHouse)
            answer++;
        
        return isLightHouse;
    }
}