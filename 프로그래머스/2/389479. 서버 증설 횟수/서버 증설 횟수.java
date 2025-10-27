import java.util.*;
// 8분
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        int total = 0;
        for(int i=0 ; i<players.length; i++){
            int n = players[i] / m;
            total -= prefix.getOrDefault(i, 0);
            
            if(total < n){
                prefix.put(i + k, prefix.getOrDefault(i + k, 0) + n - total);
                answer += n - total;
                total = n;
            }
        }
        
        return answer;
    }
}