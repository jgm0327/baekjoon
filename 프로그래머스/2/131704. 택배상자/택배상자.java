import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        ArrayDeque<Integer> mainConveyorBelt = new ArrayDeque<>();
        ArrayDeque<Integer> subConveyorBelt = new ArrayDeque<>();
        
        for(int i=1 ; i<= order.length ; i++){
            mainConveyorBelt.add(i);
        }
        
        for(int i=0 ; i<order.length ; i++){
            
            while(!mainConveyorBelt.isEmpty() 
                  && mainConveyorBelt.peek() < order[i]){
                subConveyorBelt.add(mainConveyorBelt.poll());
            }
            
            if(!mainConveyorBelt.isEmpty() 
               && mainConveyorBelt.peek() == order[i]){
                mainConveyorBelt.poll();
                answer++;
                continue;
            }
            
            if(!subConveyorBelt.isEmpty() 
               && subConveyorBelt.peekLast() == order[i]){
                subConveyorBelt.pollLast();
                answer++;
                continue;
            }
            
            break;
        }
        
        return answer;
    }
}