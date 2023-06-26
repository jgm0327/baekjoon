import java.util.*;

class Solution {
    private List<int[]>[] graph;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new ArrayList[N + 1];
        for(int i=0 ; i<=N ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] r : road){
            int sour = r[0], des = r[1], cost = r[2];
            graph[sour].add(new int[]{des, cost});
            graph[des].add(new int[]{sour, cost});
        }
        answer = dikjstra(N, K);
        return answer;
    }
    
    private int dikjstra(int N, int k){
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        pq.add(new int[]{1, 0});
        costs[1] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int sour = cur[0], cnt = cur[1];
            if(cnt > costs[sour])continue;
            for(int[] next : graph[sour]){
                int des = next[0], nextCost = next[1] + costs[sour];
                if(costs[des] > nextCost){
                    costs[des] = nextCost;
                    pq.add(new int[]{des, nextCost});
                }
            }
        }
        
        int ret = 0;
        for(int i = 1 ; i<=N ; i++){
            if(k >= costs[i])ret++;
        }
        return ret;
    }
}