import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> {
            // if(o1[0] != o2[0])
            //     return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int prev = routes[0][0] - 1;
        for(int[] route : routes){
            if(prev >= route[0]){
                continue;
            }
            // System.out.println(route[0] + " " + route[1]);
            answer++;
            prev = route[1];
        }
        return answer;
    }
    
    // [-20, -15], [-19, -5], [-18, -13], [-14, -5], [-5, -3]
    
    /*
        
        
        prev = -15, -18 <= prev
        prev = -15 -14 > prev -> prev = -5
        prev = -5 prev <= -5
        
    */
    
}