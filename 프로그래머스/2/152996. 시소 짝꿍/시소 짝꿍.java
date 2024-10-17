import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> ori = new HashMap<>();
        
        boolean[][] visit = new boolean[1001][1001];
        for(int weight : weights){
            ori.put(weight, ori.getOrDefault(weight, 0L) + 1);
        }
        
        for(int o1 : ori.keySet()){
            answer += (ori.get(o1) * (ori.get(o1) - 1)) / 2;
            visit[o1][o1] = true;
            
            for(int o2 : ori.keySet()){
                if(visit[o1][o2])
                    continue;
                
                if(canRide(o1, o2)){
                    answer += ori.get(o1) * ori.get(o2);
                    visit[o1][o2] = visit[o2][o1] = true;
                }
            }
        }
        
        return answer;
    }
    
    private boolean canRide(int o1, int o2){
        for(int i=2 ; i<=4 ; i++){
            for(int j=2 ; j<=4 ; j++){
                if(o1 * i == o2 * j){
                    return true;
                }
            }
        }
        
        return false;
    }
}