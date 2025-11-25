import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (o1, o2) -> {
           if(o1[0] != o2[0])
               return o1[0] - o2[0];
            
            return o1[1] - o2[1];
        });
        
        int s = targets[0][0], e = targets[0][1];
        for(int[] target : targets){
            int start = target[0], end =  target[1];
            
            if(e <= start){
                s = start;
                e = end;
                answer++;
                continue;
            }
            
            s = Math.max(s, start);
            e = Math.min(e ,end);
        }
        
        return answer;
    }
}