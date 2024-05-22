import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int sc : scoville){
            pq.add((long)sc);    
        }
        
        int cnt = 0;
        while(true){
            if(pq.peek() >= K){
                answer = cnt;
                break;
            }
            
            cnt++;
            long first = pq.poll();
            
            if(pq.isEmpty()){
                break;
            }
            
            long second = pq.poll();
            
            long total = first + second * 2;
            
            pq.add(total);
        }
        
        return answer;
    }
}