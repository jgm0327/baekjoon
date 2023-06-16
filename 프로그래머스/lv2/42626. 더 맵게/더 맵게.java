import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0 ; i<scoville.length ; i++){
            pq.add(scoville[i]);
        }
        
        while(!pq.isEmpty() && pq.peek() < K){
            int num1 = pq.poll();
            if(pq.isEmpty())break;
            answer++;
            int num2 = pq.poll() * 2;
            pq.add(num1 + num2);
        }
        if(pq.isEmpty())answer = -1;
        return answer;
    }
}