import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, cnt = 0, idx = 0, time = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        while(cnt < jobs.length){
            while(idx < jobs.length && time >= jobs[idx][0]){
                pq.add(jobs[idx++]);
            }
            if(pq.isEmpty()){
                time = jobs[idx][0];
            }else{
                int[] cur = pq.poll();
                answer += (time - cur[0] + cur[1]);
                time += cur[1];
                cnt++;
            }
        }
        
        answer = answer / jobs.length;
        return answer;
    }
}