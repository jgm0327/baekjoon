import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0, idx = 0;
        int[] arr = new int[2 * stations.length];
        
        for(int station : stations){
            arr[idx++] = Math.max(station - w, 1);
            arr[idx++] = Math.min(station + w, n);
        }
        
        if(arr[0] != 1)
            answer += Math.ceil((double)(arr[0] - 1) / (2 * w + 1));
        
        for(int i=2 ; i<arr.length ; i+=2){
            if(arr[i] == arr[i - 1])
                continue;
            
            
            answer += Math.ceil((double)(arr[i] - arr[i - 1] - 1) / (2 * w + 1));
            
        }
        
        if(arr[arr.length - 1] != n)
            answer += Math.ceil((double)(n - arr[arr.length - 1]) / (2 * w + 1));

        return answer;
    }
}