import java.util.*;

class Solution {
    int answer;
    Map<String, Integer> index;
    int[][] points = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        
        index = new HashMap<>();
        index.put("diamond", 0);
        index.put("iron", 1);
        index.put("stone", 2);
        
        int count = picks[0] + picks[1] + picks[2];
        
        dfs(0, picks, minerals, count, 0);
        
        return answer;
    }
    
    void dfs(int start, int[] picks, String[] minerals, int count, int total){
        if(minerals.length <= start || count == 0){
            answer = Math.min(total, answer);
            return;
        }
        
        for(int i=0 ; i<3 ; i++){
            if(picks[i] == 0)
                continue;
            
            int sum = 0;
            for(int j=start ; j<Math.min(minerals.length, start + 5) ; j++){
                sum += points[i][index.get(minerals[j])];
            }
            
            if(total + sum >= answer)
                continue;
            
            picks[i]--;
            dfs(start + 5, picks, minerals, count - 1, total + sum);
            picks[i]++;
        }
    }
}