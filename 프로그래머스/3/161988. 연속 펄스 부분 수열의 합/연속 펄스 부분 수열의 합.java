import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        int mul = -1;
        for(int i=0 ; i<n ; i++){
            arr1[i] = sequence[i] * mul;
            arr2[i] = sequence[i] * -mul;
            
            mul *= -1;
        }
        
        long[] dp1 = new long[n + 1];
        long[] dp2 = new long[n + 1];
        
        for(int i=0 ; i<n ; i++){
            dp1[i + 1] = Math.max(dp1[i] + arr1[i], arr1[i]);
            dp2[i + 1] = Math.max(dp2[i] + arr2[i], arr2[i]);
            
            answer = Math.max(answer, Math.max(dp1[i + 1], dp2[i + 1]));
        }
        
        return answer;
    }
}