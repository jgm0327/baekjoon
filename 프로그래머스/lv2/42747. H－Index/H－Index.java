import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0, n = citations.length;
        
        Arrays.sort(citations);
        
        Map<Integer, Integer> counter = new HashMap<>();
        int prev = citations[0];
        for(int i=0 ; i<n ; i++){
            counter.put(citations[i], i);
        }
        
        for(int h = citations[n - 1] ; h >= 0 ; h--){
            for(int key : counter.keySet()){
                int count = counter.get(key);
                if(h <= key && count <= h && (n - count) >= h)return h;
            }
        }
        
        return answer;
    }
}