import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int e : enemy){
            if(n <= 0)break;
            answer++;
            
            if(pq.size() < k){
                pq.add(e);
                continue;
            }
            
            if(e > pq.peek()){
                n -= pq.poll();
                pq.add(e);
            }else{
                n -= e;
            }
            
            if(n < 0){
                answer--;
                break;
            }
        }
        
        return answer;
    }
}