import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> second = new HashMap<>();
        for(int t : topping){
            second.put(t, second.getOrDefault(t, 0) + 1);
        }
        
        for(int t : topping){
            first.put(t, first.getOrDefault(t, 0) + 1);
            second.put(t, second.get(t) - 1);
            
            if(second.get(t) == 0)
                second.remove(t);
            
            if(first.size() == second.size())
                answer++;
        }
        
        return answer;
    }
}