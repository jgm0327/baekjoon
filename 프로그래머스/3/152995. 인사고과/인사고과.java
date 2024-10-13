import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int attitude = scores[0][0], coworker = scores[0][1];
        
        Arrays.sort(scores, (o1, o2) -> {
            if(o2[1] != o1[1]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] + o2[1] - o1[0] - o1[1]);
        
        int maxValue = scores[0][0];
        for(int[] score : scores){
            int att = score[0], co = score[1];
            
            if(maxValue > att)
                continue;
            
            maxValue = att;
            pq.add(new int[]{att, co});
        }
        
        boolean canReceive = false;
        int prevTotal = pq.peek()[0] + pq.peek()[1];
        int count = 0, rank = 1;
        
        while(!pq.isEmpty()){
            int att = pq.peek()[0], co = pq.poll()[1];
            count++;
            
            if(prevTotal != att + co){
                rank = count;
                prevTotal = att + co;
            }
            
            if(att == attitude && co == coworker){
                answer = rank;
                canReceive = true;
                break;
            }
        }
        
        return canReceive ? answer : -1;
    }
}