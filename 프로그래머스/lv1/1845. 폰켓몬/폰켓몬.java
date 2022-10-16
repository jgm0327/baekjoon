import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length / 2;
        
        Map<Integer, Integer> pocketMon = new HashMap<>();
        for(int num : nums){
            if(pocketMon.containsKey(num)) continue;
            pocketMon.put(num, 1);
            answer += 1;
            if(answer >= len){
                answer = answer > len ? answer - 1 : answer;
                break;
            }
        }
        
        
        return answer;
    }
}