import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for(int i=n - 1 ; i>=0 ; i--){
            while(!stk.isEmpty() && stk.peekLast() <= numbers[i]){
                stk.pollLast();
            }
            
            if(stk.isEmpty()){
                answer[i] = -1;
            }
            else{
                answer[i] = stk.peekLast();
            }
            
            stk.add(numbers[i]);
        }
        
        return answer;
    }
}