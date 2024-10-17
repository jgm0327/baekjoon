import java.util.*;

class Solution {
    final int[][] stamina = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        int n = minerals.length;
        int[][] counts = new int[(n / 5) + 1][3];
        
        Map<String, Integer> index = Map.of("diamond", 0, "iron", 1, "stone", 2);
        
        for(int i=0 ; i<n ; i+=5){
            for(int j=0 ; j<5 ; j++){
                if(i + j >= n)break;
                counts[i / 5][index.get(minerals[i + j])]++;
            }
        }
        
        int countTotal = 0;
        for(int i=0 ; i<3 ; i++)
            countTotal += picks[i];
        
        dfs(0, 0, countTotal, picks, counts);
        
        return answer;
    }
    
    private void dfs(int idx, int total, int totalCount, int[] picks, int[][] counts){
        if(counts.length == idx || totalCount == 0){
            answer = Math.min(answer, total);
            return;
        }
        
        for(int pickIdx = 0 ; pickIdx < 3 ; pickIdx++){
            if(picks[pickIdx] == 0)
                continue;
            
            picks[pickIdx]--;
            int sum = 0;
            for(int j=0 ; j<3 ; j++){
                sum += stamina[pickIdx][j] * counts[idx][j];
            }
            
            dfs(idx + 1, total + sum, totalCount - 1, picks, counts);
            picks[pickIdx]++;
        }
    }
}