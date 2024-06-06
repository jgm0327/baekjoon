import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE, count = 0;
    Map<String, Integer> index;
    final int[][] stamina = {{1,1,1},{5,1,1},{25,5,1}};
    
    public int solution(int[] picks, String[] minerals) {
        
        for(int pick : picks){
            count += pick;
        }
        
        index = new HashMap<>();
        index.put("diamond", 0);
        index.put("iron", 1);
        index.put("stone", 2);
        
        dfs(0, 0, picks, minerals, 0);
        
        return answer;
    }
    
    private void dfs(int depth, int total, int[] picks, final String[] minerals, int start){
        if(depth == count){
            answer = Math.min(answer, total);
        }
        
        for(int i=0 ; i<3 ; i++){
            if(picks[i] == 0)
                continue;
            
            int sum = 0;
            for(int j=start ; j<start+5 ; j++){
                if(j >= minerals.length)
                    break;
                
                sum += stamina[i][index.get(minerals[j])];
                
            }
            picks[i]--;
            dfs(depth + 1, total + sum, picks, minerals, start + 5);
            picks[i]++;
        }
    }
}