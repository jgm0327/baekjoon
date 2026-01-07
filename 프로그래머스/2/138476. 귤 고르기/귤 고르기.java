import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int answer = 0;
        
        for(int t : tangerine){
            numbers.put(t, numbers.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int key : numbers.keySet()){
            pq.add(numbers.get(key));
        }
        
        while(k > 0){
            answer++;
            k -= pq.poll();
        }
        
        return answer;
    }
}