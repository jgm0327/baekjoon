import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        ArrayDeque<int[]> stk = new ArrayDeque<>();
        
        for(int i=0 ; i<numbers.length ; i++){
            while(!stk.isEmpty() && stk.peekLast()[0] < numbers[i]){
                int[] peek = stk.pollLast();
                answer[peek[1]] = numbers[i];
            }
            if(stk.isEmpty() || stk.peekLast()[0] >= numbers[i])stk.addLast(new int[]{numbers[i], i});
        }
        
        while(!stk.isEmpty()){
            int[] peek = stk.pollLast();
            answer[peek[1]] = -1;
        }
        return answer;
    }
}