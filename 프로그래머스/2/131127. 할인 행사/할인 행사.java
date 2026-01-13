import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = want.length;
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> wantNumber = new HashMap<>();
        
        for(int i=0 ; i<want.length ; i++){
            wantNumber.put(want[i], number[i]);
        }
        
        for(int i=0 ; i<10 ; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        if(count(want, wantNumber, map))
            answer++;
        
        int left = 0, right = 10;
        while(right < discount.length){
            map.put(discount[left], map.get(discount[left]) - 1);
            map.put(discount[right], map.getOrDefault(discount[right], 0) + 1);
            
            left++;
            right++;
            
            if(count(want, wantNumber, map))
                answer++;
        }
        
        
        return answer;
    }
    
    boolean count(String[] names, Map<String, Integer> count, Map<String, Integer> map){
        for(String name : names){
            if(count.get(name) != map.getOrDefault(name, 0))
                return false;
        }
        
        return true;
    }
}