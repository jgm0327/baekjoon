import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int work : works){
            pq.add(work);
        }
        
        while(n-- > 0 && !pq.isEmpty()){
            int num = pq.poll() - 1;
            if(num <= 0)
                continue;
            pq.add(num);
        }
        
        while(!pq.isEmpty()){
            answer += pq.peek() * pq.poll();
        }
        
        return answer;
    }
}